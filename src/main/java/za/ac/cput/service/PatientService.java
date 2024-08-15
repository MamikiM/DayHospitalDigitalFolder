package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Patient;
import za.ac.cput.repository.PatientRepository;


import java.util.List;
@Service
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;
    private PatientRepository repository;

    @Autowired
    PatientService(PatientRepository repository, PatientRepository patientRepository){
        this.repository = repository;
        this.patientRepository = patientRepository;
    }



    public Patient getDetailsOfPatient(String id){
        return repository.findByPatientId(id);
    }


    @Override
    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Patient update(Patient patient) {
        return repository.save(patient);
    }


    @Override
    public List<Patient> getAll() {
        return repository.findAll();
    }
}
