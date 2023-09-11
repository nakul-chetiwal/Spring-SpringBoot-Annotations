package com.spring.annotation.SpringAnnotation.controller;

import com.spring.annotation.SpringAnnotation.config.MailProps;
import com.spring.annotation.SpringAnnotation.entity.Student;
import com.spring.annotation.SpringAnnotation.exception.StudentNotFoundException;
import com.spring.annotation.SpringAnnotation.model.LazyLoadingBean;
import com.spring.annotation.SpringAnnotation.model.TestBean;
import com.spring.annotation.SpringAnnotation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@PropertySource("classpath:custom.properties")
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

    // key value found from application.properties
    @Value("${mail.from}")
    private String fromm;

    @Value("${mail.host}")
    private String hostt;

    @Value("${mail.port}")
    private String portt;

    // key value found from custom.properties- @propertysource() annotation is required to find key value from non application.properties
    @Value("${message}")
    private String message;


    @Autowired
    private MailProps mailProps;


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
        System.out.println("value from application.properties--mail.from: " + fromm + " mail.host: " + hostt + " mail.port: " + portt);
        System.out.println("value from custom.properties--message" + message );
        // since @Data annotation is used in MailProps class, toString() method is overridden
        System.out.println("mailProps class properties value: " + mailProps);
        testBean.TestBeanMethod();
        return ResponseEntity.ok(studentService.getStudents());
    }

}
