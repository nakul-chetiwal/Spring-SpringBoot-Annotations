package com.spring.annotation.SpringAnnotation.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
