package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public String studentPage(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("student", new Student()); // Form trống mặc định
        model.addAttribute("editing", false); // Không ở chế độ chỉnh sửa
        return "student";
    }

    @GetMapping("/student/edit/{studentId}")
    public String editStudent(@PathVariable("studentId") String studentId, Model model) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            model.addAttribute("students", studentRepository.findAll());
            model.addAttribute("editing", true); // Chuyển sang chế độ sửa
        } else {
            // Trường hợp không tìm thấy -> về trang chính
            return "redirect:/student";
        }
        return "student";
    }

    @PostMapping("/student/save")
    public String saveStudent(@RequestParam("editing") boolean editing,
                              @ModelAttribute Student student) {
        if (editing) {
            // Nếu đang chỉnh sửa
            Optional<Student> existing = studentRepository.findById(student.getStudentId());
            if (existing.isPresent()) {
                Student updated = existing.get();
                updated.setFullname(student.getFullname());
                updated.setGender(student.getGender());
                updated.setDateOfBirth(student.getDateOfBirth());
                updated.setMajor(student.getMajor());
                studentRepository.save(updated);
            }
        } else {
            // Thêm mới nếu chưa tồn tại
            if (!studentRepository.existsById(student.getStudentId())) {
                studentRepository.save(student);
            }
        }
        return "redirect:/student";
    }

    @GetMapping("/student/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") String studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        }
        return "redirect:/student";
    }

    
    @GetMapping("/students/all")
    public String getAllStudentsFragment(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "fragments/student-list"; 
    }

}
