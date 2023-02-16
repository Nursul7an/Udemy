package modul2.edu.udemy.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtToken {
    String firstName;
    String email;
    String token;
    String tokenType;
    String roleStatus;
}
