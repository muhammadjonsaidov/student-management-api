package uz.pdp.student_management.service;

import uz.pdp.student_management.dto.StudentDTO;
import uz.pdp.student_management.dto.StudentResponse;
import uz.pdp.student_management.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentResponse createStudent(StudentDTO dto);
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student updateStudent(UUID id, Student student);
    void deleteStudent(UUID id);
}
