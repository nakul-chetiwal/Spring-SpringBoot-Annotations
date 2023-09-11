package com.spring.annotation.SpringAnnotation.controller;

import com.spring.annotation.SpringAnnotation.entity.Student;
import com.spring.annotation.SpringAnnotation.exception.StudentNotFoundException;
import com.spring.annotation.SpringAnnotation.model.EagerLoadingBean;
import com.spring.annotation.SpringAnnotation.model.LazyLoadingBean;
import com.spring.annotation.SpringAnnotation.model.TestBean;
import com.spring.annotation.SpringAnnotation.service.StudentService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    // In Qualifier annotation use Alias name i.e Just make first letter of clas small letter
    @Autowired
    private StudentService studentService;

    @Autowired
    private TestBean testBean;

    // spring bean (lazyLoadingBean) is created because we have autowired it. EagerLoadingBean is created even though the @Autowired is not use(DI is not done)
    @Autowired
    private LazyLoadingBean lazyLoadingBean;

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
        testBean.TestBeanMethod();
        return ResponseEntity.ok(studentService.getStudents());
    }

}
