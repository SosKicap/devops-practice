package com.thymeleaf.demo.service;

import com.thymeleaf.demo.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudentById(Long id);
	void updateStudent(Long id, Student student);
}
