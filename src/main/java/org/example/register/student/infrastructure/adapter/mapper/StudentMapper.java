package org.example.register.student.infrastructure.adapter.mapper;

import org.example.register.student.domain.model.Student;
import org.example.register.student.domain.model.value_object.*;
import org.example.register.student.infrastructure.adapter.input.rest.dto.CreateStudentDto;
import org.example.register.student.infrastructure.adapter.input.rest.dto.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toDomain(CreateStudentDto dto) {
        return new Student(
                null,
                new Username(dto.getUsername()),
                new Name(dto.getName()),
                new LastName(dto.getLastName()),
                new Password(dto.getPassword()),
                new DateBirth(dto.getBirthDate()),
                new DateRange(dto.getRegistrationStartDate(), dto.getRegistrationEndDate()),
                new ImagePath(dto.getImagePath())
        );
    }

    public StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName().name());
        dto.setLastName(student.getLastName().lastName());
        dto.setBirthDate(student.getDateBirth().birthDate());
        dto.setRegistrationStartDate(student.getRegistrationDateRange().startDate());
        dto.setRegistrationEndDate(student.getRegistrationDateRange().endDate());
        dto.setImagePath(student.getImagePath().imagePath());
        dto.setUsername(student.getUsername().username());
        return dto;
    }
}
