package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.Staff;
import za.ac.cput.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/receptionist")
    public String showReceptionistPage(Model model, HttpSession session){
        Staff staff = (Staff) session.getAttribute("staff");
        model.addAttribute("staff", staff);
        return "receptionistView";
    }

    @GetMapping("/createAppointment")
    public String showCreateAppointment(Model model){
        model.addAttribute("appointment", new Appointment());
        return "createAppointment";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(Model model, @RequestParam String email, @RequestParam String mobile, @RequestParam String date, @RequestParam String time, @RequestParam String firstName, @RequestParam String lastName){

       Appointment appointment = new Appointment();
       appointment.setFirstName(firstName);
       appointment.setLastName(lastName);
       appointment.setEmail(email);
       appointment.setDate(LocalDate.parse(date));
       appointment.setTime(LocalTime.parse(time));
       appointment.setMobile(Long.valueOf(mobile));

       if(appointmentService.checkDuplicate(appointment)){
           model.addAttribute("errorMessage", "Appointment already exists");
           return "createAppointment";
       }

       appointmentService.create(appointment);

       System.out.println(appointment);
       return "redirect:/createAppointment";
    }

    @GetMapping("/showAppointments")
    public String showAppointmentPage(Model model){
        List<Appointment> appointments = appointmentService.getAll();
        model.addAttribute("appointmentList", appointments);
        return "ViewAppointment";
    }

    @PostMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        System.out.println("Appointment deleted");

        return "redirect:/showAppointments";

    }

   
    @PostMapping("/updateAppointment")
    public String updateAppointment(@ModelAttribute Appointment appointment, Model model) {
        appointmentService.update(appointment);
        return "redirect:/showAppointments";
    }
}