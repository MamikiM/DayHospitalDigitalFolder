package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.LoginCredentials;

public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials,String> {
}
