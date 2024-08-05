package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Appointment;
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
    public String showReceptionistPage(Model model){
        model.addAttribute("staff", new Staff());
        return "receptionistView";
    }

    @GetMapping("/createAppointment")
    public String showCreateAppointment(Model model){
        model.addAttribute("appointment");
        return "createAppointment";
    }


    @PostMapping("/saveAppointment")
    public String saveAppointment(@RequestParam String email, @RequestParam String mobile, @RequestParam String date, @RequestParam String time, @RequestParam String firstName, @RequestParam String lastName){

       Appointment appointment = new Appointment();
       appointment.setFirstName(firstName);
       appointment.setLastName(lastName);
       appointment.setEmail(email);
       appointment.setDate(LocalDate.parse(date));
       appointment.setTime(LocalTime.parse(time));
       appointment.setMobile(Long.valueOf(mobile));

       appointmentService.create(appointment);

        System.out.println(appointment);
        return "createAppointment";

    }

    @GetMapping("/showAppointments")
    public String showAppointmentPage(Model model){
        List<Appointment> appointments = appointmentService.getAll();

        model.addAttribute("appointmentList", appointments);

        return "ViewAppointment";
    }

}
