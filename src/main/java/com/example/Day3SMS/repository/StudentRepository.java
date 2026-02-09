package com.example.Day3SMS.repository;

import com.example.Day3SMS.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<StudentModel, String> {

    // Find student by email
    Optional<StudentModel> findByEmail(String email);

    // Find students by name (case-insensitive)
    List<StudentModel> findByNameIgnoreCase(String name);

    // Find students by age
    List<StudentModel> findByAge(int age);

    // Find students by age range
    List<StudentModel> findByAgeBetween(int minAge, int maxAge);

    // Find students by name containing (case-insensitive)
    List<StudentModel> findByNameContainingIgnoreCase(String name);

    // Check if student exists by email
    boolean existsByEmail(String email);

    // Custom query: Find students older than specified age
    @Query("{ 'age' : { $gt: ?0 } }")
    List<StudentModel> findStudentsOlderThan(int age);

    // Custom query: Find students younger than specified age
    @Query("{ 'age' : { $lt: ?0 } }")
    List<StudentModel> findStudentsYoungerThan(int age);

    // Custom query: Find students by name pattern
    @Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
    List<StudentModel> findStudentsByNamePattern(String pattern);
}
