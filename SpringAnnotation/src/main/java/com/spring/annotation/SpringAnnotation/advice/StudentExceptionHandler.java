package com.spring.annotation.SpringAnnotation.advice;

import com.spring.annotation.SpringAnnotation.exception.StudentNotFoundException;
import com.spring.annotation.SpringAnnotation.model.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<AppError> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
        AppError error=new AppError(UUID.randomUUID().toString(),
                studentNotFoundException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);


    }
}
