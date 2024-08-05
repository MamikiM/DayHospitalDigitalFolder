package za.ac.cput.service;
import za.ac.cput.domain.LoginCredentials;
import java.util.List;
public interface ILoginCredentialsService extends IService<LoginCredentials,String>{
    List<LoginCredentials> getAll();
}
