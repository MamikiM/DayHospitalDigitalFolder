package za.ac.cput.service;
import za.ac.cput.domain.Staff;
import java.util.List;
    public interface IStaffService extends IService<Staff,String>{
        List<Staff> getAll();

        boolean validateStaff(String empId,String password);

        Staff findByIdAndPassword(String id,String password);

        void delete(String id);
    }

