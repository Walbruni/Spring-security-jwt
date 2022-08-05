package teste2.teste2springsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import teste2.teste2springsecurityjwt.model.User;
import teste2.teste2springsecurityjwt.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    public void createUser(User user){
        String pass = user.getPassword();
        //criptografando antes de salvar no banco de dados
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}