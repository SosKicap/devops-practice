package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.model.Student;
import com.thymeleaf.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> listStudents = studentService.getAllStudents();
        model.addAttribute("listStudents", listStudents);
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("successMessage", "Student saved successfully!");
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        studentService.updateStudent(id, student);
        redirectAttributes.addFlashAttribute("successMessage", "Student updated successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudentById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully!");
        return "redirect:/";
    }
    
    @GetMapping("/students")
    public String viewStudentList(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index"; // student list page
    }

}


