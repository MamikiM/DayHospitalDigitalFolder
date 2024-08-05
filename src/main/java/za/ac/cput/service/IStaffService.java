package za.ac.cput.service;
import za.ac.cput.domain.Staff;
import java.util.List;
    public interface IStaffService extends IService<Staff,String>{
        List<Staff> getAll();
    }

