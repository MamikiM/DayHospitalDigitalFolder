package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PharmacyQueue;
import za.ac.cput.domain.Staff;
import za.ac.cput.domain.Super_Admin;
import za.ac.cput.repository.Super_AdminRepository;
import za.ac.cput.service.PatientService;
import za.ac.cput.service.PharmacyQueueService;
import za.ac.cput.service.StaffService;
import za.ac.cput.service.Super_AdminService;

import java.util.List;

@Controller
public class SuperAdminContoller {
    @Autowired
    private Super_AdminService service;
    @Autowired
    private StaffService StaffServices;
    @Autowired
    private PatientService PatientServices;
    @Autowired
    private PharmacyQueueService PharmacyqueueService;

    @GetMapping("/0987_AdminLogin")
    public String AdminLoginPage() {
        return "AdminLogin";
    }

    @PostMapping("/AddStaff")
    public String AddStaff(@RequestParam String employeeId ,
                           @RequestParam String employeeRole,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String password) {
     Staff newstaff = new Staff();
     newstaff.setEmployeeId(employeeId);
     newstaff.setEmployeeRole(employeeRole);
     newstaff.setName(name);
     newstaff.setSurname(surname);
     newstaff.setPassword(password);

     System.out.println(newstaff.toString());
     StaffServices.create(newstaff);
        return "redirect:/AdminStaff";
    }

    @PostMapping("/UpdateStaff")
    public String UpdateStaff(@RequestParam("employeeId") String employeeId ,
                           @RequestParam("employeeRole") String employeeRole,
                           @RequestParam("name") String name,
                           @RequestParam("surname") String surname,
                           @RequestParam("password") String password) {
        Staff newstaff = new Staff();
        newstaff.setEmployeeId(employeeId);
        newstaff.setEmployeeRole(employeeRole);
        newstaff.setName(name);
        newstaff.setSurname(surname);
        newstaff.setPassword(password);

        System.out.println(newstaff.toString());
        StaffServices.update(newstaff);
        return "redirect:/AdminStaff";
    }

    @PostMapping("/DeleteStaff")
    public String DeleteStaff(@RequestParam String staffId  ){

        System.out.println(staffId);
        StaffServices.delete(staffId);

        return "redirect:/AdminStaff";
    }

    @PostMapping("/AddPatient")
    public String AddPatient(@RequestParam String patientId ,
                             @RequestParam String firstName,
                             @RequestParam String lastName){
        Patient newpatient = new Patient();
        newpatient.setPatientId(patientId);
        newpatient.setFirstName(firstName);
        newpatient.setLastName(lastName);

        System.out.println(newpatient);
        PatientServices.create(newpatient);

        return "redirect:/AdminPatient";
    }

    @PostMapping("/DeletePatient")
    public String AddPatient(@RequestParam String patientId  ){

        System.out.println(patientId);
        PatientServices.delete(patientId);

        return "redirect:/AdminPatient";
    }

    @PostMapping("/UpdatePatient")
    public String UpdatePatient(@RequestParam("patientId") String patientId ,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("allergies") String allergies,
                                @RequestParam("prescribedMedication") String prescribedMedication){
        Patient newpatient = new Patient();
        newpatient.setPatientId(patientId);
        newpatient.setFirstName(firstName);
        newpatient.setLastName(lastName);
        newpatient.setAllergies(allergies);
        newpatient.setPrescribedMedication(prescribedMedication);

        System.out.println(newpatient);
        PatientServices.update(newpatient);

        return "redirect:/AdminPatient";
    }

    @GetMapping("/AdminStaff")
    public String AdminStaff(Model model) {
        List<Staff> AllStaff = StaffServices.getAll();
        model.addAttribute("staffList", AllStaff);
        return "StaffSuperAdminPage";
    }

    @GetMapping("/AdminPatient")
    public String AdminPatient(Model model) {
        List<Patient> AllPatients = PatientServices.getAll();
        model.addAttribute("patientList", AllPatients);
        return "PatientSuperAdminPage";
    }

    @GetMapping("/CleaPharmacyQueue")
    public String CleaPharmacyQueue() {
        PharmacyqueueService.deleteAll();
        return "redirect:/AdminStaff";
    }

    @PostMapping("/VerifyAdmin")
    public String VerifyAdmin(@RequestParam String AdminID ,
                              @RequestParam String UserName,
                              @RequestParam String Email,
                              @RequestParam String password
                              ) {
        Super_Admin admin =service.read(AdminID);
        if(admin.getUserName().equalsIgnoreCase(null)){
            System.out.println("Admin not found");
            return "AdminLogin";
        }else if(admin.getAdminID().equalsIgnoreCase(AdminID)||
        admin.getPassword().equalsIgnoreCase(password)||
        admin.getEmail().equalsIgnoreCase(Email)||
        admin.getUserName().equalsIgnoreCase(UserName)){

            return "redirect:/AdminStaff";
        }
        return "AdminLogin";
    }






}
