package modul2.edu.udemy.repository;

import modul2.edu.udemy.model.entity.ResetPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetPasswordRepo extends JpaRepository<ResetPassword, Long> {
    Optional<ResetPassword> findResetPasswordByLinks(String links);
}
