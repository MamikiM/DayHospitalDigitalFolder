package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CreateMedicalHistory;

import java.util.List;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<CreateMedicalHistory,Integer> {

    List<CreateMedicalHistory> findCreateMedicalHistoriesByPatientIdMh(String id);
}
