package uz.pdp.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.student_management.model.Student;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
