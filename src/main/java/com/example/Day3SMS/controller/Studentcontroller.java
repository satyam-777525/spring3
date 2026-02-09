package com.example.Day3SMS.controller;

import com.example.Day3SMS.dto.StudentRequestDto;
import com.example.Day3SMS.dto.StudentResponseDto;
import com.example.Day3SMS.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class Studentcontroller {
    
    private final StudentService service;

    public Studentcontroller(StudentService service) {
        this.service = service;
    }

    // Test endpoint
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working");
    }

    // CREATE Student
    @PostMapping
    public ResponseEntity<StudentResponseDto> addStudent(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        StudentResponseDto response = service.addStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Alternative endpoint for backward compatibility
    @PostMapping("/add-student")
    public ResponseEntity<StudentResponseDto> addStudentAlternative(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        StudentResponseDto response = service.addStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET All Students
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getStudents() {
        List<StudentResponseDto> students = service.getStudents();
        return ResponseEntity.ok(students);
    }

    // GET Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable String id) {
        StudentResponseDto student = service.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // UPDATE Student
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto studentRequestDto) {
        StudentResponseDto response = service.updateStudent(id, studentRequestDto);
        return ResponseEntity.ok(response);
    }

    // Alternative endpoint for backward compatibility
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto> updateStudentAlternative(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto studentRequestDto) {
        StudentResponseDto response = service.updateStudent(id, studentRequestDto);
        return ResponseEntity.ok(response);
    }

    // DELETE Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        String message = service.deleteStudent(id);
        return ResponseEntity.ok(message);
    }
}
