package modul2.edu.udemy.service.impls;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.exception.EmailAlreadyExistsException;
import modul2.edu.udemy.maper.UserMapper;
import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.RegisterRequest;
import modul2.edu.udemy.model.entity.User;
import modul2.edu.udemy.repository.UserRepo;
import modul2.edu.udemy.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto register(RegisterRequest request) {
        if (userRepo.existsByEmail(request.getEmail()))
            throw new EmailAlreadyExistsException("The email was already registered");
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.getUserStatus().castByType(request);
        User user = userMapper.toUser(request);
        User saveUser = userRepo.save(user);
        return userMapper.toDto(saveUser);
    }
}
