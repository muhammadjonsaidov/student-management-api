package uz.pdp.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDTO {
    @NotBlank(message = "Name is required")
    private String name;
    
    @Email(message = "Email is required")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 16, message = "Age must be at least 16")
    private int age;

    public StudentDTO() {
    }

    public StudentDTO(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
