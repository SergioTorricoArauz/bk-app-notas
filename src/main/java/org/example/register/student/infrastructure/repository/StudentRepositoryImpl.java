package org.example.register.student.infrastructure.repository;

import org.example.register.student.domain.model.Student;
import org.example.register.student.domain.model.value_object.*;
import org.example.register.student.domain.port.output.StudentRepository;
import org.example.register.student.infrastructure.entity.StudentEntity;
import org.example.register.student.infrastructure.repository.jpa.JpaStudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {

    private final JpaStudentRepository jpaStudentRepository;

    public StudentRepositoryImpl(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }

    @Override
    public void save(Student student) {
        StudentEntity entity = mapToEntity(student);
        jpaStudentRepository.save(entity);
    }

    @Override
    public Optional<Student> findById(Long id) {
        Optional<StudentEntity> entity = jpaStudentRepository.findById(id);
        return entity.map(this::mapToDomain);
    }

    @Override
    public List<Student> findAll() {
        List<StudentEntity> entities = jpaStudentRepository.findAll();
        return entities.stream().map(this::mapToDomain).toList();
    }


    @Override
    public void deleteStudent(Long id) {
        jpaStudentRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpaStudentRepository.existsByUsername(username);
    }

    private StudentEntity mapToEntity(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setUsername(student.getUsername().username());
        entity.setName(student.getName().name());
        entity.setLastName(student.getLastName().lastName());
        entity.setPassword(student.getPassword().password());
        entity.setBirthDate(student.getDateBirth().birthDate());
        entity.setRegistrationStartDate(student.getRegistrationDateRange().startDate());
        entity.setRegistrationEndDate(student.getRegistrationDateRange().endDate());
        entity.setImagePath(student.getImagePath().imagePath());
        return entity;
    }


    private Student mapToDomain(StudentEntity entity) {
        return new Student(
                entity.getId(),
                new Username(entity.getUsername()),
                new Name(entity.getName()),
                new LastName(entity.getLastName()),
                null,
                new DateBirth(entity.getBirthDate()),
                new DateRange(entity.getRegistrationStartDate(), entity.getRegistrationEndDate()),
                new ImagePath(entity.getImagePath())
        );
    }

}
