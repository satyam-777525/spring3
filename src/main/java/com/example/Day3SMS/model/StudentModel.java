package com.example.Day3SMS.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class StudentModel {

    @Id
    private String id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 5, message = "Age cannot be less than 5")
    @Max(value = 90, message = "Age cannot be more than 90")
    private int age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;
}
