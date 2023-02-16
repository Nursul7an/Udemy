package modul2.edu.udemy.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordRequest {
    @NotBlank
    String newPassword;
    @NotBlank
    String repeatedPassword;
}
