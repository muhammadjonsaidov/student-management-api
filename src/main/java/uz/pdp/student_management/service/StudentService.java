package uz.pdp.student_management.service;

import uz.pdp.student_management.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student updateStudent(UUID id, Student student);
    void deleteStudent(UUID id);
}
