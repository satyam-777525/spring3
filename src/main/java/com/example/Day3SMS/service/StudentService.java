package com.example.Day3SMS.service;

import com.example.Day3SMS.model.StudentModel;
import com.example.Day3SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE Student
    public StudentModel addStudent(StudentModel student) {
        return repository.save(student);
    }


}
