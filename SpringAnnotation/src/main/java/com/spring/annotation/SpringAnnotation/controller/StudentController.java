package com.spring.annotation.SpringAnnotation.controller;

import com.spring.annotation.SpringAnnotation.entity.Student;
import com.spring.annotation.SpringAnnotation.exception.StudentNotFoundException;
import com.spring.annotation.SpringAnnotation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    public StudentController() {
        System.out.println("controller object created ....");
    }

    @PostMapping("/save")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable int id) throws StudentNotFoundException {
        Optional<Student> student = studentService.getStudent(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else {
            throw new StudentNotFoundException("student not found with id " + id);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

}
