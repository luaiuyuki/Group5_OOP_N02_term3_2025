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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class AjaxSemesterTranscriptController {

    private final TranscriptRepository transcriptRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public AjaxSemesterTranscriptController(TranscriptRepository transcriptRepo,
                                            StudentRepository studentRepo,
                                            CourseRepository courseRepo) {
        this.transcriptRepo = transcriptRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    
    @GetMapping("/search-transcript")
    public String searchSemesterPage() {
        return "search-transcript";
    }

    @GetMapping("/transcripts/search-by-semester")
    public String getTranscriptBySemester(@RequestParam("semester") String semester, Model model) {
        List<Transcript> transcripts = transcriptRepo.findBySemester(semester);

        model.addAttribute("transcripts", transcripts);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result-semester :: transcriptTableSemester";
    }

    @PostMapping("/ajax-semester-transcript/save")
    public String saveSemesterTranscript(@ModelAttribute Transcript transcript,
                                         @RequestParam("editing") boolean editing,
                                         Model model) {

        Optional<Student> student = studentRepo.findById(transcript.getStudent().getStudentId());
        Optional<Course> course = courseRepo.findById(transcript.getCourse().getCourseID());

        if (student.isEmpty() || course.isEmpty()) {
            model.addAttribute("transcripts", List.of());
            return "fragments/transcript-result-semester :: transcriptTableSemester";
        }

        transcript.setStudent(student.get());
        transcript.setCourse(course.get());

        if (editing && transcript.getId() != null) {
            transcriptRepo.findById(transcript.getId()).ifPresent(existing -> {
                existing.setGrade10(transcript.getGrade10());
                existing.setSemester(transcript.getSemester());
                existing.setStudent(transcript.getStudent());
                existing.setCourse(transcript.getCourse());
                transcriptRepo.save(existing);
            });
        } else {
            transcriptRepo.save(transcript);
        }

        List<Transcript> updatedList = transcriptRepo.findBySemester(transcript.getSemester());

        model.addAttribute("transcripts", updatedList);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result-semester :: transcriptTableSemester";
    }

    @GetMapping("/ajax-semester-transcript/edit/{id}")
    public String editSemesterTranscript(@PathVariable("id") Long id, Model model) {
        Optional<Transcript> optionalTranscript = transcriptRepo.findById(id);
        if (optionalTranscript.isEmpty()) {
            model.addAttribute("transcripts", List.of());
            return "fragments/transcript-result-semester :: transcriptTableSemester";
        }

        Transcript transcript = optionalTranscript.get();
        List<Transcript> list = transcriptRepo.findBySemester(transcript.getSemester());

        model.addAttribute("transcripts", list);
        model.addAttribute("transcript", transcript);
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", true);

        return "fragments/transcript-result-semester :: transcriptTableSemester";
    }

    @GetMapping("/ajax-semester-transcript/delete/{id}")
    public String deleteSemesterTranscript(@PathVariable("id") Long id,
                                           @RequestParam("semester") String semester,
                                           Model model) {

        transcriptRepo.deleteById(id);

        List<Transcript> list = transcriptRepo.findBySemester(semester);
        model.addAttribute("transcripts", list);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result-semester :: transcriptTableSemester";
    }
}
