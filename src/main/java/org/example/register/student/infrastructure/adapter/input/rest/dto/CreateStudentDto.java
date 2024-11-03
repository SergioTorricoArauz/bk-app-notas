package org.example.register.student.infrastructure.adapter.input.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CreateStudentDto {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;
    private String imagePath;
    private String username;
    private String password;
}
