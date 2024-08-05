package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
