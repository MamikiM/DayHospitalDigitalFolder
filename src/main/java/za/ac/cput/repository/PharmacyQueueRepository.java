package za.ac.cput.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.LoginCredentials;
import za.ac.cput.domain.PharmacyQueue;

import java.util.List;

@Repository
public interface PharmacyQueueRepository extends JpaRepository<PharmacyQueue,String> {

    PharmacyQueue findPharmacyQueueByPatientId(String id);

    boolean existsPharmacyQueueByPatientId(String id);

void deletePharmacyQueueByPatientId(String id);



    }

