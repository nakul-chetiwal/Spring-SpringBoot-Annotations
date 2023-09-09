package com.spring.annotation.SpringAnnotation.service;

import com.spring.annotation.SpringAnnotation.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentServiceImplV2 implements StudentService{
    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public Optional<Student> getStudent(int id) {
        return Optional.empty();
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }
}
