package modul2.edu.udemy.service.impls;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.exception.EmailAlreadyExistsException;
import modul2.edu.udemy.exception.ExpiredException;
import modul2.edu.udemy.exception.NotFoundException;
import modul2.edu.udemy.maper.ResetPasswordMapper;
import modul2.edu.udemy.maper.UserMapper;
import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.LoginRequest;
import modul2.edu.udemy.model.dto.request.PasswordRequest;
import modul2.edu.udemy.model.dto.request.RegisterRequest;
import modul2.edu.udemy.model.dto.response.JwtToken;
import modul2.edu.udemy.model.entity.ResetPassword;
import modul2.edu.udemy.model.entity.User;
import modul2.edu.udemy.repository.ResetPasswordRepo;
import modul2.edu.udemy.repository.UserRepo;
import modul2.edu.udemy.service.MailService;
import modul2.edu.udemy.service.UserService;
import modul2.edu.udemy.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final ResetPasswordMapper resetPasswordMapper;
    private final ResetPasswordRepo resetPasswordRepo;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

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

    @Override
    public void sendLinkForReset(String email) {
        User user = userRepo.findUserByEmail(email)
                .orElseThrow(()-> new NotFoundException("No user found with email "+ email));
        ResetPassword resetPassword = resetPasswordMapper.toResetPassword(user);

        resetPasswordRepo.save(resetPassword);
        mailService.sendMessage(user.getEmail(),"Reset password", "Click the below to reset password" +
                "localhost:8080/user/reset/password"+ resetPassword.getLinks());
    }

    @Override
    public void resetPassword(String link, PasswordRequest passwordRequest) {
        ResetPassword resetPassword = validateLink(link);
        if (!passwordRequest.getNewPassword().equals(passwordRequest.getRepeatedPassword()))
            throw new RuntimeException("The password does not match each other");

        resetPassword.getUser().setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
        userRepo.save(resetPassword.getUser());
        resetPasswordRepo.delete(resetPassword);
    }

    @Override
    public JwtToken login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        return userMapper.toJwt(user, jwt);
    }

    private ResetPassword validateLink(String link) {
        ResetPassword password = resetPasswordRepo.findResetPasswordByLinks(link)
                .orElseThrow(()->new NotFoundException("No such a object found with link " + link));
        if (password.getLocalDateTime().plusHours(24).isBefore(LocalDateTime.now())){
            throw new ExpiredException("Link has been expired");
        }
        return password;
    }
}
