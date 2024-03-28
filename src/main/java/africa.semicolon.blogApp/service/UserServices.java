package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.reponse.RegistrationResponse;
import africa.semicolon.blogApp.dtos.request.RegistrationRequest;

public interface UserServices {
    //void registerUser(RegistrationRequest regRequest);
    RegistrationResponse registerUser(RegistrationRequest regRequest);

}
