package modul2.edu.udemy.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import modul2.edu.udemy.model.enums.Audience;
import modul2.edu.udemy.model.enums.Experience;
import modul2.edu.udemy.model.enums.UserStatus;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
    @NotBlank
    String firstName;
    String lastName;
    String email;
    String password;
    UserStatus userStatus;
    Audience audience;
    Experience experience;
}
