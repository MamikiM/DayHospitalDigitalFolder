package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.LoginCredentials;
import za.ac.cput.repository.LoginCredentialsRepository;



import java.util.List;

@Service
public class LoginCredentialsService implements ILoginCredentialsService{

    private LoginCredentialsRepository repository;

    @Autowired
    LoginCredentialsService(LoginCredentialsRepository repository){
        this.repository = repository;
    }

    @Override
    public LoginCredentials create(LoginCredentials loginCredentials) {
        return repository.save(loginCredentials);
    }

    @Override
    public LoginCredentials read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LoginCredentials update(LoginCredentials loginCredentials) {
        return repository.save(loginCredentials);
    }

    @Override
    public List<LoginCredentials> getAll() {
        return repository.findAll();
    }
}


