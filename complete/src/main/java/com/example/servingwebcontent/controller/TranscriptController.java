package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Transcript;
import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.model.Course;
import com.example.servingwebcontent.repository.TranscriptRepository;
import com.example.servingwebcontent.repository.StudentRepository;
import com.example.servingwebcontent.repository.CourseRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TranscriptController {

    private final TranscriptRepository transcriptRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public TranscriptController(TranscriptRepository transcriptRepository,
                                StudentRepository studentRepository,
                                CourseRepository courseRepository) {
        this.transcriptRepository = transcriptRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Hiển thị trang transcript
    @GetMapping("/transcript")
    public String transcriptPage(Model model) {
        model.addAttribute("transcripts", transcriptRepository.findAll());
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("editing", false);
        return "transcript";
    }

    // Chuyển sang trang sửa
    @GetMapping("/transcript/edit/{id}")
    public String editTranscript(@PathVariable("id") Long id, Model model) {
        Optional<Transcript> transcriptOpt = transcriptRepository.findById(id);
        if (transcriptOpt.isPresent()) {
            model.addAttribute("transcript", transcriptOpt.get());
            model.addAttribute("transcripts", transcriptRepository.findAll());
            model.addAttribute("students", studentRepository.findAll());
            model.addAttribute("courses", courseRepository.findAll());
            model.addAttribute("editing", true);
            return "transcript";
        }
        return "redirect:/transcript";
    }

  @PostMapping("/transcript/save")
public String saveTranscript(@RequestParam("editing") boolean editing,
                             @RequestParam(value = "id", required = false) Long id,
                             @RequestParam("studentId") String studentId,
                             @RequestParam("courseId") String courseId,
                             @RequestParam("grade10") Float grade10,
                             @RequestParam("semester") String semester) {

    Optional<Student> studentOpt = studentRepository.findById(studentId);
    Optional<Course> courseOpt = courseRepository.findById(courseId);

    if (studentOpt.isEmpty() || courseOpt.isEmpty()) {
        return "redirect:/transcript";
    }

    Transcript transcript;

    if (editing && id != null) {
        Optional<Transcript> existingOpt = transcriptRepository.findById(id);
        if (existingOpt.isPresent()) {
            transcript = existingOpt.get();
        } else {
            // Nếu không tìm thấy bản ghi để chỉnh sửa thì tạo mới
            transcript = new Transcript();
        }
    } else {
        // Tạo mới: KHÔNG set id vì DB sẽ tự sinh
        transcript = new Transcript();
    }

    transcript.setStudent(studentOpt.get());
    transcript.setCourse(courseOpt.get());
    transcript.setGrade10(grade10);
    transcript.setSemester(semester);

    transcriptRepository.save(transcript);

    return "redirect:/transcript";
}


    // Xóa transcript
    @GetMapping("/transcript/delete/{id}")
    public String deleteTranscript(@PathVariable("id") Long id) {
        if (transcriptRepository.existsById(id)) {
            transcriptRepository.deleteById(id);
        }
        return "redirect:/transcript";
    }

    // Trả về danh sách fragment (nếu dùng AJAX)
    @GetMapping("/transcripts/all")
    public String getAllTranscriptsFragment(Model model) {
        model.addAttribute("transcripts", transcriptRepository.findAll());
        return "fragments/transcript-list";
    }
}
