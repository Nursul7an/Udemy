package modul2.edu.udemy.service;

import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.RegisterRequest;

public interface UserService {
    UserDto register(RegisterRequest request);
}
