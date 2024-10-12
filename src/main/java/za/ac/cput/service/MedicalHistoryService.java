package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CreateMedicalHistory;
import za.ac.cput.domain.PharmacyQueue;
import za.ac.cput.repository.LoginCredentialsRepository;
import za.ac.cput.repository.MedicalHistoryRepository;

import java.util.List;

@Service
public class MedicalHistoryService  implements ICreateMedicalHistoryService{

    @Autowired
    private MedicalHistoryRepository repository;
    @Override
    public CreateMedicalHistory create(CreateMedicalHistory createMedicalHistory) {
        return repository.save(createMedicalHistory);
    }

    @Override
    public CreateMedicalHistory read(Integer integer) {
        return null;
    }

    @Override
    public CreateMedicalHistory update(CreateMedicalHistory createMedicalHistory) {
        return repository.save(createMedicalHistory);
    }

    public List<CreateMedicalHistory> getAllMedicalHistory(String id) {
        return repository.findCreateMedicalHistoriesByPatientIdMh(id);
    }
}
