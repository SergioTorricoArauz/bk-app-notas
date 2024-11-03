package org.example.register.student.infrastructure.adapter.input.rest;

import org.example.register.student.domain.port.input.StudentService;
import org.example.register.student.domain.model.Student;
import org.example.register.student.infrastructure.adapter.input.rest.dto.CreateStudentDto;
import org.example.register.student.infrastructure.adapter.input.rest.dto.StudentDto;
import org.example.register.student.infrastructure.adapter.mapper.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createStudent(@RequestBody CreateStudentDto studentDto) {
        Student student = studentMapper.toDomain(studentDto);
        studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<Student> students = studentService.findAll();
        List<StudentDto> dtos = students.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        StudentDto dto = studentMapper.toDto(student);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody CreateStudentDto studentDto) {
        Student student = studentMapper.toDomain(studentDto);
        student.setId(id);
        studentService.update(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
