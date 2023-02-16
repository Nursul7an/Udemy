package modul2.edu.udemy.service.impls;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.RegisterRequest;
import modul2.edu.udemy.repository.UserRepo;
import modul2.edu.udemy.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public UserDto register(RegisterRequest request) {
        return null;
    }
}
