package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.reponse.RegistrationResponse;
import africa.semicolon.blogApp.dtos.request.RegistrationRequest;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.repository.UserRepository;
import exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blogApp.utils.Mapping.map;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository repository;

    @Override
    public RegistrationResponse registerUser(RegistrationRequest registrationRequest) {
        registrationRequest.setUsername(registrationRequest.getUsername().toLowerCase());
        validate(registrationRequest.getUsername());

        User user = map(registrationRequest);

        RegistrationResponse response = map(user);
        repository.save(user);
        return response;
    }

    private void validate(String username) {
        boolean userExist = repository.existsByUsername(username);
        if (userExist) throw new UserAlreadyExistException(username + "already exists");
    }

    //    @Override
//    public void registerUser(RegistrationRequest regRequest) {
//        User user = new User();
//        user.setFirstName(regRequest.getFirstName());
//        user.setLastName(regRequest.getLastName());
//        user.setPassword(regRequest.getPassword());
//        user.setEmail(regRequest.getUsername());
//        repository.save(user);
//    }
}
