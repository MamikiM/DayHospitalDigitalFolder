package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Super_Admin;
import za.ac.cput.repository.PatientRepository;
import za.ac.cput.repository.Super_AdminRepository;

import java.util.List;

@Service
public class Super_AdminService implements ISuper_AdminService{
    @Autowired
    private Super_AdminRepository repository;

    @Override
    public List<Super_Admin> getAll() {
        return repository.findAll();
    }



    @Override
    public Super_Admin create(Super_Admin superAdmin) {
        return null;
    }

    @Override
    public za.ac.cput.domain.Super_Admin read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public za.ac.cput.domain.Super_Admin update(za.ac.cput.domain.Super_Admin superAdmin) {
        return null;
    }
}
