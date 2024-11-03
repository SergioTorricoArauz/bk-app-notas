package org.example.register.student.application.service;

import org.example.register.student.application.util.PasswordHasher;
import org.example.register.student.domain.exception.DomainException;
import org.example.register.student.domain.model.Student;
import org.example.register.student.domain.model.value_object.Password;
import org.example.register.student.domain.port.input.StudentService;
import org.example.register.student.domain.port.output.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        if (studentRepository.existsByUsername(student.getUsername().username())) {
            throw new DomainException("El nombre de usuario ya está en uso");
        }

        String rawPassword = student.getPassword().password();
        String hashedPassword = PasswordHasher.hashPassword(rawPassword);

        Password encryptedPassword = new Password(hashedPassword);
        student.setPassword(encryptedPassword);

        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.orElseThrow(() -> new DomainException("Estudiante no encontrado con ID: " + id));

        student.setPassword(null);
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> student.setPassword(null));
        return students;
    }

    @Override
    public void update(Student student) {
        Optional<Student> existingStudentOpt = studentRepository.findById(student.getId());
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();

            if (!existingStudent.getUsername().username().equals(student.getUsername().username())) {
                if (studentRepository.existsByUsername(student.getUsername().username())) {
                    throw new DomainException("El nombre de usuario ya está en uso");
                }
            }

            if (student.getPassword() != null && student.getPassword().password() != null) {
                String rawPassword = student.getPassword().password();
                String hashedPassword = PasswordHasher.hashPassword(rawPassword);
                student.setPassword(new Password(hashedPassword));
            } else {
                student.setPassword(existingStudent.getPassword());
            }
            studentRepository.save(student);
        } else {
            throw new DomainException("No se puede actualizar. Estudiante no encontrado con ID: " + student.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteStudent(id);
        } else {
            throw new DomainException("No se puede eliminar. Estudiante no encontrado con ID: " + id);
        }
    }
}
