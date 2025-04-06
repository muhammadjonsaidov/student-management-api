package uz.pdp.student_management.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.student_management.model.Student;
import uz.pdp.student_management.service.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
    }
}
