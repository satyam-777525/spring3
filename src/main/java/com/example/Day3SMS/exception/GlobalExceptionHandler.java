package com.example.Day3SMS.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation errors from @Valid annotation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errorMap.put(error.getField(), error.getDefaultMessage())
        );

        return new ErrorResponse(
                400,
                "Validation failed",
                errorMap
        );
    }

    // Constraint violation errors
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errorMap.put(fieldName, message);
        });

        return new ErrorResponse(
                400,
                "Validation constraint violated",
                errorMap
        );
    }

    // Student not found exception
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleStudentNotFound(StudentNotFoundException ex) {
        return new ErrorResponse(
                404,
                ex.getMessage(),
                null
        );
    }

    // Generic runtime exceptions
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRuntimeException(RuntimeException ex) {
        return new ErrorResponse(
                500,
                ex.getMessage() != null ? ex.getMessage() : "An unexpected error occurred",
                null
        );
    }

    // Generic exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                500,
                "An internal server error occurred",
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
