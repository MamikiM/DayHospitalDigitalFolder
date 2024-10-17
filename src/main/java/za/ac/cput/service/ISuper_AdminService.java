package za.ac.cput.service;

import za.ac.cput.domain.Staff;
import za.ac.cput.domain.Super_Admin;

import java.util.List;

public interface ISuper_AdminService  extends IService<Super_Admin,String>{
    List<Super_Admin> getAll();


}
