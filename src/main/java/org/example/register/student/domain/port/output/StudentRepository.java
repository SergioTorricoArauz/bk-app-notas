package org.example.register.student.domain.port.output;

import org.example.register.student.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void deleteStudent(Long id);

    boolean existsByUsername(String username);
}
