package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.RegistrationRequest;
import africa.semicolon.blogApp.models.repository.UserRepository;
import exception.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServicesImplTest {
    @Autowired
    UserServices userServices;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
    }

    @Test
    public void registerOneUser_userIsOne(){
        RegistrationRequest userRegisterRequest = new RegistrationRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");

        userServices.registerUser(userRegisterRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void cantRegisterUserWithSameUsername(){
        RegistrationRequest userRegisterRequest = new RegistrationRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");

        userServices.registerUser(userRegisterRequest);
        assertThrows(UserAlreadyExistException.class, ()->userServices.registerUser(userRegisterRequest));
        assertEquals(1, userRepository.count());
    }
}


