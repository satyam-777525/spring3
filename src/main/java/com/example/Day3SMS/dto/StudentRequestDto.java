package com.example.Day3SMS.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 5, message = "Age cannot be less than 5")
    @Max(value = 90, message = "Age cannot be more than 90")
    private int age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    // Default constructor
    public StudentRequestDto() {
    }

    // Parameterized constructor
    public StudentRequestDto(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
