package modul2.edu.udemy.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import modul2.edu.udemy.model.enums.UserStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    UserStatus userStatus;
    Long audienceId;
    Long experienceId;
}
