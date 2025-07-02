package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Course;
import com.example.servingwebcontent.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/course")
    public String coursePage(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("course", new Course()); // Form trống
        model.addAttribute("editing", false);
        return "course";
    }

    @GetMapping("/course/edit/{courseId}")
    public String editCourse(@PathVariable("courseId") String courseId, Model model) {
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        if (courseOpt.isPresent()) {
            model.addAttribute("course", courseOpt.get());
            model.addAttribute("courses", courseRepository.findAll());
            model.addAttribute("editing", true);
        } else {
            return "redirect:/course";
        }
        return "course";
    }

    @PostMapping("/course/save")
    public String saveCourse(@RequestParam("editing") boolean editing,
                              @ModelAttribute Course course) {
        if (editing) {
            Optional<Course> existing = courseRepository.findById(course.getCourseID());
            if (existing.isPresent()) {
                Course updated = existing.get();
                updated.setCourseName(course.getCourseName());
                updated.setCredits(course.getCredits());
                updated.setStatus(course.getStatus());
                courseRepository.save(updated);
            }
        } else {
            if (!courseRepository.existsById(course.getCourseID())) {
                courseRepository.save(course);
            }
        }
        return "redirect:/course";
    }

    @GetMapping("/course/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") String courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        }
        return "redirect:/course";
    }
    @GetMapping("/courses/all")
public String getAllCoursesFragment(Model model) {
    model.addAttribute("courses", courseRepository.findAll());
    return "fragments/course-list";
}

}
