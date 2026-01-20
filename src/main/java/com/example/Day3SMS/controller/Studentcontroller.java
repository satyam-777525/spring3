package com.example.Day3SMS.controller;

import com.example.Day3SMS.model.StudentModel;
import com.example.Day3SMS.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Studentcontroller {
  private final StudentService service;

    public Studentcontroller(StudentService service) {
        this.service = service;
    }
    @GetMapping("/test")
    public String test(){
        return "API is working";
    }

    // create function API
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
//        System.out.println(student);
        return service.addStudent(student);
    }
}
