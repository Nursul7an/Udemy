package modul2.edu.udemy.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import modul2.edu.udemy.model.enums.Audience;
import modul2.edu.udemy.model.enums.Experience;
import modul2.edu.udemy.model.enums.UserStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    UserStatus userStatus;
    Audience audience;
    Experience experience;
    boolean isMentor;

}
