package org.example.register.student.infrastructure.configuration;

import org.example.register.student.application.service.StudentServiceImpl;
import org.example.register.student.domain.port.input.StudentService;
import org.example.register.student.domain.port.output.StudentRepository;
import org.example.register.student.infrastructure.repository.StudentRepositoryImpl;
import org.example.register.student.infrastructure.repository.jpa.JpaStudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public StudentRepository studentRepository(JpaStudentRepository jpaStudentRepository) {
        return new StudentRepositoryImpl(jpaStudentRepository);
    }

    @Bean
    public StudentService studentService(StudentRepository studentRepository) {
        return new StudentServiceImpl(studentRepository);
    }
}

