package modul2.edu.udemy.maper;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.model.entity.ResetPassword;
import modul2.edu.udemy.model.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ResetPasswordMapper {
    public ResetPassword toResetPassword(User user) {
        return ResetPassword.builder()
                .links(UUID.randomUUID().toString())
                .localDateTime(LocalDateTime.now())
                .user(user)
                .build();
    }
}
