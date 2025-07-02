package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserRepository userRepo;
    private final StudentRepository studentRepository;

    public LoginController(UserRepository userRepo, StudentRepository studentRepository) {
        this.userRepo = userRepo;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

   @PostMapping("/login")
   public String login(@RequestParam String username,
                    @RequestParam String password,
                    HttpSession session,
                    Model model) {
    User user = userRepo.findByUsernameAndPassword(username, password);
    if (user != null) {
        session.setAttribute("user", user.getUsername());
        session.setAttribute("role", user.getRole());
        return "redirect:/home";
    } else {
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
