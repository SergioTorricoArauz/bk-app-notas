package org.example.register.student.domain.port.input;

import org.example.register.student.domain.model.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void update(Student student);

    void deleteById(Long id);
}

