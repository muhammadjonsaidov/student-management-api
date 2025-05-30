package uz.pdp.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.student_management.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
