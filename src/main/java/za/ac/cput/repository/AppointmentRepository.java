package za.ac.cput.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Appointment findByAppointmentId(Long appointmentId);

    boolean existsByEmailAndDateAndTime(String email, LocalDate date, LocalTime time);

}
