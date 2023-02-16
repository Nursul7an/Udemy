package modul2.edu.udemy.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reset_passwords")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResetPassword {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
            @JoinColumn(name = "user_id")
    User user;
    @Column(name = "links")
    String links;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    LocalDateTime localDateTime;
}
