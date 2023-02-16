package modul2.edu.udemy.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "experiences")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Experience {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String experience;
}
