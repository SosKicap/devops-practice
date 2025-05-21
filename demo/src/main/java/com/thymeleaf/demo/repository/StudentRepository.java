package com.thymeleaf.demo.repository;

import com.thymeleaf.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // No additional methods needed for basic CRUD
}
