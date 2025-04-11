package uz.pdp.student_management.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private UUID id;
    private String name;
    private String email;
    private int age;
}
