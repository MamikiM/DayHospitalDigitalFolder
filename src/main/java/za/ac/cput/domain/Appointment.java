package za.ac.cput.domain;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private String firstName;
    private String lastName;

    private Long mobile;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime time;



    public Appointment(){}


    public Appointment(String firstName, Long mobile, String lastName, String email, LocalDate date, LocalTime time) {
        this.firstName = firstName;
        this.mobile = mobile;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
        this.time = time;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Long getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public Appointment setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Appointment setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Appointment setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
        return this;
    }

    public Appointment setMobile(Long mobile) {
        this.mobile = mobile;
        return this;
    }

    public Appointment setEmail(String email) {
        this.email = email;
        return this;
    }

    public Appointment setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Appointment setTime(LocalTime time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, firstName, lastName, mobile, email, date, time);
    }


}
