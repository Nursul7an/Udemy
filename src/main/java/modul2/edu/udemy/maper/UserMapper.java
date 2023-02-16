package modul2.edu.udemy.maper;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.RegisterRequest;
import modul2.edu.udemy.model.dto.response.JwtToken;
import modul2.edu.udemy.model.entity.User;
import modul2.edu.udemy.model.enums.UserStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User toUser(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .audience(request.getAudience())
                .experience(request.getExperience())
                .useRole(request.getUserStatus())
                .build();
        if (user.getUseRole() == UserStatus.USER_MENTOR) user.setMentor(true);
        return user;
    }

    public UserDto toDto(User saveUser) {
        return UserDto.builder()
                .id(saveUser.getId())
                .firstName(saveUser.getFirstName())
                .lastName(saveUser.getLastName())
                .email(saveUser.getEmail())
                .isMentor(saveUser.isMentor())
                .userStatus(saveUser.getUseRole())
                .build();
    }

    public JwtToken toJwt(User user, String jwt) {
        return JwtToken.builder()
                .token(jwt)
                .tokenType("Bearer ")
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .roleStatus(user.getUseRole().toString())
                .build();
    }
}
