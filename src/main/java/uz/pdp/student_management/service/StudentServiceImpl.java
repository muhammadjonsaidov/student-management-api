package uz.pdp.student_management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.student_management.ApiResponse;
import uz.pdp.student_management.dto.StudentDTO;
import uz.pdp.student_management.dto.StudentResponse;
import uz.pdp.student_management.model.Student;
import uz.pdp.student_management.repository.StudentRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponse createStudent(StudentDTO dto) {
        Student student = modelMapper.map(dto, Student.class);
        Student saved = studentRepository.save(student);

        return modelMapper.map(saved, StudentResponse.class);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Student> studentPage = studentRepository.findAll(pageable);

        List<StudentResponse> responses = studentPage.stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .toList();

        return ResponseEntity.ok(new ApiResponse<>(true, "Students fetched", responses));
    }


    /*@Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }*/

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(UUID id, Student student) {
        Student existing = getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());
        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }
}
