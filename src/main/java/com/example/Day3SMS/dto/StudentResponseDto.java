package com.example.Day3SMS.dto;

public class StudentResponseDto {

    private String id;
    private String name;
    private int age;
    private String email;
    private String message;

    // Default constructor
    public StudentResponseDto() {
    }

    // Parameterized constructor
    public StudentResponseDto(String id, String name, int age, String email, String message) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.message = message;
    }

    // Constructor without message
    public StudentResponseDto(String id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.message = null;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "StudentResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
