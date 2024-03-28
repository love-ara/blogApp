package africa.semicolon.blogApp.utils;

import africa.semicolon.blogApp.dtos.reponse.RegistrationResponse;
import africa.semicolon.blogApp.dtos.request.RegistrationRequest;
import africa.semicolon.blogApp.models.data.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapping {

    public static User map(RegistrationRequest registrationRequest){
        User user = new User();
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword());
        return user;
    }
    public static RegistrationResponse map(User user){
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setUsername (user.getUsername());
        registrationResponse.setId(user.getId());
        registrationResponse.setResponseDate(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss").format(user.getDateCreated()));
        return registrationResponse;
    }

}
