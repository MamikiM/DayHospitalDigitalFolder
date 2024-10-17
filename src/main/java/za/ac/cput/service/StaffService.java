package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Staff;
import za.ac.cput.repository.StaffRepository;


import java.util.List;

@Service
public class StaffService implements IStaffService {

    private StaffRepository repository;

    @Autowired
    StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Staff create(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public Staff read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Staff update(Staff staff) {
        return repository.save(staff);
    }


//    public boolean validateLogin(String name, String role, String id, String password) {
//        return repository.existsByNameAndEmployeeIdAndEmployeeRoleAndPassword(name, id, role, password);
//    }

    @Override
    public List<Staff> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean validateStaff(String empId, String password) {
        return repository.existsByEmployeeIdAndPassword(empId, password);
    }

    @Override
    public Staff findByIdAndPassword(String id, String password) {
        return repository.findByEmployeeIdAndPassword(id, password);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

