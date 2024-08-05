package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.PharmacyQueue;
import za.ac.cput.repository.PharmacyQueueRepository;

import java.util.List;

@Service
public class PharmacyQueueService {

    private PharmacyQueueRepository repository;

    @Autowired
    PharmacyQueueService(PharmacyQueueRepository repository){
        this.repository = repository;
    }
    public PharmacyQueue createPharmacyQueue(PharmacyQueue pharmacyQueue) {
        return repository.save(pharmacyQueue);
    }

    public List<PharmacyQueue> getAllPharmacyQueues() {
        return repository.findAll();
    }

    public PharmacyQueue showTreatment(String id){
        return repository.findPharmacyQueueByPatientId(id);
    }
}
