package org.example.register.student.infrastructure.repository.jpa;

import org.example.register.student.infrastructure.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentRepository extends JpaRepository<StudentEntity, Long> {
    boolean existsByUsername(String username);
}
