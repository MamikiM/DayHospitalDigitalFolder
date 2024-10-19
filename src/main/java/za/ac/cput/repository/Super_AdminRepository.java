package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Staff;
import za.ac.cput.domain.Super_Admin;

public interface Super_AdminRepository extends JpaRepository<Super_Admin,String> {
}
