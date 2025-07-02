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
import java.util.List;


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

    // Hiển thị trang Transcript
    @GetMapping("/transcript")
    public String transcriptPage(Model model) {
        model.addAttribute("transcripts", transcriptRepository.findAll());
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("editing", false);
        return "transcript";
    }

    // Chỉnh sửa bản ghi transcript theo ID
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

    // Lưu hoặc cập nhật transcript
    @PostMapping("/transcript/save")
    public String saveTranscript(@RequestParam("editing") boolean editing,
                                 @ModelAttribute Transcript transcript) {

        Optional<Student> studentOpt = studentRepository.findById(transcript.getStudent().getStudentId());
        Optional<Course> courseOpt = courseRepository.findById(transcript.getCourse().getCourseID());

        if (studentOpt.isEmpty() || courseOpt.isEmpty()) {
            return "redirect:/transcript";
        }

        transcript.setStudent(studentOpt.get());
        transcript.setCourse(courseOpt.get());

        if (editing) {
            Optional<Transcript> existing = transcriptRepository.findById(transcript.getId());
            if (existing.isPresent()) {
                Transcript updated = existing.get();
                updated.setGrade10(transcript.getGrade10());
                updated.setSemester(transcript.getSemester());
                updated.setStudent(transcript.getStudent());
                updated.setCourse(transcript.getCourse());
                transcriptRepository.save(updated);
                return "redirect:/transcript/edit/" + updated.getId().toString();
            }
        } else {
            Transcript saved = transcriptRepository.save(transcript);
            return "redirect:/transcript/edit/" + saved.getId().toString();
        }

        return "redirect:/transcript";
    }

    // Xóa transcript
    @GetMapping("/transcript/delete/{id}")
    public String deleteTranscript(@PathVariable("id") Long id) {
        transcriptRepository.deleteById(id);
        return "redirect:/transcript";
    }

    // Trả về fragment danh sách transcript 
    @GetMapping("/transcripts/all")
    public String getAllTranscriptsFragment(Model model) {
        model.addAttribute("transcripts", transcriptRepository.findAll());
        return "fragments/transcript-list";
    }
    
     
}
