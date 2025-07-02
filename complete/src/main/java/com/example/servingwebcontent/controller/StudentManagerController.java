package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentManagerController {

    @GetMapping("/student-manager")
    public String studentManagerPage() {
        return "student-manager";  
    }
}
