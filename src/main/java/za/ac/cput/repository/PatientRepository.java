package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Patient;


import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository <Patient,String> {
    Patient findByPatientId(String id);

}












