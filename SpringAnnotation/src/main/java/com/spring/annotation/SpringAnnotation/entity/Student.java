package com.spring.annotation.SpringAnnotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "STUDENT_TBL")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "STUDENT_NAME")
    private String name;
    @Column(name = "ROLL_NO")
    private Integer rollNo;
    @Column(name = "DEPT")
    private String dept;

}