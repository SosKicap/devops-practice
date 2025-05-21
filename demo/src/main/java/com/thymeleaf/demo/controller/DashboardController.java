package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"/", "/dashboard"})
    public String viewDashboard(Model model) {
        model.addAttribute("welcomeMessage", "Welcome to the Student Management Dashboard!");
        model.addAttribute("totalStudents", studentRepository.count());
        return "dashboard";
    }
}
