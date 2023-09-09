package com.spring.annotation.SpringAnnotation.repository;

import com.spring.annotation.SpringAnnotation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
