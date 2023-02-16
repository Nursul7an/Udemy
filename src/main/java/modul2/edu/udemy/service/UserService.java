package modul2.edu.udemy.service;

import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.LoginRequest;
import modul2.edu.udemy.model.dto.request.PasswordRequest;
import modul2.edu.udemy.model.dto.request.RegisterRequest;
import modul2.edu.udemy.model.dto.response.JwtToken;

public interface UserService {
    UserDto register(RegisterRequest request);

    void sendLinkForReset(String email);

    void resetPassword(String link, PasswordRequest passwordRequest);

    JwtToken login(LoginRequest loginRequest);


}
