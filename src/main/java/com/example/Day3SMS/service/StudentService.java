package com.example.Day3SMS.service;

import com.example.Day3SMS.dto.StudentRequestDto;
import com.example.Day3SMS.dto.StudentResponseDto;
import com.example.Day3SMS.exception.StudentNotFoundException;
import com.example.Day3SMS.model.StudentModel;
import com.example.Day3SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE Student
    public StudentResponseDto addStudent(StudentRequestDto requestDto) {
        StudentModel student = convertToModel(requestDto);
        StudentModel savedStudent = repository.save(student);
        return convertToResponseDto(savedStudent, "Student added successfully");
    }

    // GET All Students
    public List<StudentResponseDto> getStudents() {
        List<StudentModel> students = repository.findAll();
        return students.stream()
                .map(student -> convertToResponseDto(student, null))
                .collect(Collectors.toList());
    }

    // GET Student by ID
    public StudentResponseDto getStudentById(String id) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        return convertToResponseDto(student, null);
    }

    // UPDATE Student
    public StudentResponseDto updateStudent(String id, StudentRequestDto requestDto) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        
        existingStudent.setName(requestDto.getName());
        existingStudent.setAge(requestDto.getAge());
        existingStudent.setEmail(requestDto.getEmail());

        StudentModel updatedStudent = repository.save(existingStudent);
        return convertToResponseDto(updatedStudent, "Student updated successfully");
    }

    // DELETE Student
    public String deleteStudent(String id) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        repository.delete(existingStudent);
        return "Student deleted successfully";
    }

    // Check if student exists
    public boolean studentExists(String id) {
        return repository.existsById(id);
    }

    // Convert StudentRequestDto to StudentModel
    private StudentModel convertToModel(StudentRequestDto dto) {
        StudentModel model = new StudentModel();
        model.setName(dto.getName());
        model.setAge(dto.getAge());
        model.setEmail(dto.getEmail());
        return model;
    }

    // Convert StudentModel to StudentResponseDto
    private StudentResponseDto convertToResponseDto(StudentModel model, String message) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setAge(model.getAge());
        dto.setEmail(model.getEmail());
        dto.setMessage(message);
        return dto;
    }
}
