package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.CreateMedicalHistory;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PharmacyQueue;
import za.ac.cput.domain.Staff;
import za.ac.cput.service.MedicalHistoryService;
import za.ac.cput.service.PatientService;
import za.ac.cput.service.PharmacyQueueService;
import za.ac.cput.service.StaffService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class StaffController {



    @Autowired
    private StaffService staffService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PharmacyQueueService pharmacyQueueService;
    @Autowired
    private MedicalHistoryService medicalHistoryService;
    List<CreateMedicalHistory> mhList;

    @GetMapping("/showHistoryPage")
    public String test(Model model) {
        model.addAttribute("viewMedicalHistory", new Staff());
        return "ViewMedicalHistory";
    }


    @GetMapping("/populateMedicalHistory")
    public String showHistory(@RequestParam String patientId, Model model) {
        mhList = medicalHistoryService.getAllMedicalHistory(patientId);
        model.addAttribute("historyList", mhList);
        System.out.println(mhList.toString());
        return "showPatientHistory";
    }

    @GetMapping("/showPh")
    public String showData(Model model) {
        return "redirect:/showPatientHistory";
    }

    @GetMapping("/createMedicalHistory")
    public String createHistory(@RequestParam String patientId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String testResults, @RequestParam String allergies, @RequestParam String prescribedMedication, @RequestParam String treatmentPlan) {
        CreateMedicalHistory medicalHistory = new CreateMedicalHistory();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        medicalHistory.setPatientIdMh(patientId);
        medicalHistory.setFirstNameMh(firstName);
        medicalHistory.setLastNameMh(lastName);
        medicalHistory.setTestResultsMh(testResults);
        medicalHistory.setAllergiesMh(allergies);
        medicalHistory.setPrescribedMedicationMh(prescribedMedication);
        medicalHistory.setTreatmentPlanMh(treatmentPlan);
        medicalHistory.setDateCreateMh(formatter.format(date).toString());
        medicalHistoryService.create(medicalHistory);
        PharmacyQueue pharmacyQueue = new PharmacyQueue();
        if (pharmacyQueueService.checkQueue(patientId) == true) {
            return "existInQueue";
        }
        pharmacyQueue.setPatientId(patientId);
        pharmacyQueue.setFirstName(firstName);
        pharmacyQueue.setLastName(lastName);
        pharmacyQueue.setPrescribedMedication(prescribedMedication);
        pharmacyQueue.setTreatmentPlan(treatmentPlan);
        pharmacyQueueService.createPharmacyQueue(pharmacyQueue);
        return "doctorView";
    }


    @GetMapping("/login")
    public String showForm(Model model) {
        model.addAttribute("staff", new Staff());
        return "staff";
    }


    @GetMapping("/loginCredentials")
    public String showLogin(Model model) {
        model.addAttribute("loginCredentials", new Staff());
        return "loginCredentials";
    }

    @GetMapping("/doctorPage")
    public String doctorPAge(Model model) {
        return "doctorView";
    }

    @GetMapping("/getFolderDetails")
    public String showDetails(@RequestParam String patientId, Model model) {
        Patient patient = patientService.getDetailsOfPatient(patientId);
        model.addAttribute("patient", patient);
        return "doctorView";
    }

    @GetMapping("/navigateToLogin")
    public String showLoginPage() {
        return "loginCredentials";
    }


    @PostMapping("/save")
    public String saveStaff(Staff staff) {
        staffService.create((staff));
        return "redirect:/loginCredentials";

    }

    @PostMapping("/login")
    public String validateLogin(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {
        boolean isValidLogin = staffService.validateStaff(id, password);
        Staff findStaffMember = staffService.findByIdAndPassword(id, password);

        if (isValidLogin) {
            if (findStaffMember.getEmployeeRole().equalsIgnoreCase("Doctor")) {
                return "doctorView";
            } else if (findStaffMember.getEmployeeRole().equalsIgnoreCase("Pharmacist")) {
                return "redirect:/pharmacyQueues";
            } else if (findStaffMember.getEmployeeRole().equalsIgnoreCase("Receptionist")) {
                model.addAttribute("patient", new Patient());
                session.setAttribute("staff", findStaffMember);

                return "redirect:/receptionist";
            } else {
                return "incorrect";
            }
        }
        return "loginCredentials";
    }


    @PostMapping("/savePatient")
    public String savePatient(Patient patient) {
        patientService.create(patient);
        return "redirect:/createPatient";
    }

   /* @PostMapping("/assignToQueue")
    public String assign(@RequestParam String patientId, @RequestParam String firstName,@RequestParam String lastName,@RequestParam String prescribedMedication,@RequestParam String treatmentPlan){
        PharmacyQueue pharmacyQueue = new PharmacyQueue();
        pharmacyQueue.setPatientId(patientId);
        pharmacyQueue.setFirstName(firstName);
        pharmacyQueue.setLastName(lastName);
        pharmacyQueue.setPrescribedMedication(prescribedMedication);
        pharmacyQueue.setTreatmentPlan(treatmentPlan);
        pharmacyQueueService.createPharmacyQueue(pharmacyQueue);
        return "doctorView";
    }*/

    @GetMapping("/pharmacy")
    public String showPharmacyPage() {
        return "pharmacistView";
    }

/*
    @GetMapping("/getPharmacyQueue")
    public String showDetailsInQueue(String patientId, Model model) {
        Patient patient = patientService.getDetailsOfPatient(patientId);
        model.addAttribute("patient", patient);
        return "doctorView";
    }*/

    @GetMapping("/pharmacyQueues")
    public String getAllPharmacyQueues(Model model) {
        List<PharmacyQueue> pharmacyQueues = pharmacyQueueService.getAllPharmacyQueues();
        model.addAttribute("pharmacyQueues", pharmacyQueues);
        return "pharmacistView";
    }

    @GetMapping("/showPatientDetails")
    public String showPatientDetails(@RequestParam String patientId, Model model) {
        PharmacyQueue pharmacyQueue = pharmacyQueueService.showTreatment(patientId);
        String treatment = pharmacyQueue.getTreatmentPlan();
        String medication = pharmacyQueue.getPrescribedMedication();
        model.addAttribute("treatment", treatment);
        model.addAttribute("medication", medication);
        return "medicationTreatment";
    }

    @PostMapping("/deletePatientDetails")
    public String deletePatientDetails(@RequestParam String patientId, Model model) {
        List<PharmacyQueue> pharmacyQueues = pharmacyQueueService.getAllPharmacyQueues();
        model.addAttribute("pharmacyQueues", pharmacyQueues);
        pharmacyQueueService.deleteIndividualPatientInQueue(patientId);
        return "redirect:/showDeletePatientFolder";
    }

    @GetMapping("/showDeletePatientFolder")
    public String deletePatientDetails(Model model) {
        List<PharmacyQueue> pharmacyQueues = pharmacyQueueService.getAllPharmacyQueues();
        model.addAttribute("pharmacyQueues", pharmacyQueues);
        return "deletePatientFolder";
    }

    @GetMapping("/createPatient")
    public String showCreatePatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "createPatientFolder";
    }

    @GetMapping("/showPatients")
    public String showPatientPage(Model model) {
        List<Patient> patients = patientService.getAll();

        model.addAttribute("patientList", patients);

        return "viewPatientFolder";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute Patient patient) {
       System.out.println(patient);
       Patient patient1 = patientService.read(patient.getPatientId());
       System.out.println(patient1);
        patientService.update(patient1);
       
        return "redirect:/showPatients";
        
    }

    

}






