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
public class AjaxCourseTranscriptController {

    private final TranscriptRepository transcriptRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public AjaxCourseTranscriptController(TranscriptRepository transcriptRepo,
                                          StudentRepository studentRepo,
                                          CourseRepository courseRepo) {
        this.transcriptRepo = transcriptRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    // Trang tìm kiếm theo course
    @GetMapping("/search-course")
    public String searchCoursePage() {
        return "search-course";
    }

    // Trả về fragment danh sách bảng điểm theo courseID
    @GetMapping("/transcripts/search-by-course")
    public String getTranscriptByCourseId(@RequestParam("courseID") String courseID, Model model) {
        List<Transcript> transcripts = transcriptRepo.findByCourse_CourseID(courseID);

        model.addAttribute("transcripts", transcripts);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result-course :: transcriptTableCourse";
    }

    // Lưu hoặc cập nhật bảng điểm (theo course)
    @PostMapping("/ajax-course-transcript/save")
    public String saveCourseTranscript(@ModelAttribute Transcript transcript,
                                       @RequestParam("editing") boolean editing,
                                       Model model) {

        Optional<Student> student = studentRepo.findById(transcript.getStudent().getStudentId());
        Optional<Course> course = courseRepo.findById(transcript.getCourse().getCourseID());

        if (student.isEmpty() || course.isEmpty()) {
            model.addAttribute("transcripts", List.of());
            return "fragments/transcript-result-course :: transcriptTableCourse";
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

        // Trả lại danh sách bảng điểm theo courseID
        List<Transcript> updatedList = transcriptRepo.findByCourse_CourseID(transcript.getCourse().getCourseID());

        model.addAttribute("transcripts", updatedList);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result-course :: transcriptTableCourse";
    }

    // Sửa transcript theo ID
    @GetMapping("/ajax-course-transcript/edit/{id}")
    public String editCourseTranscript(@PathVariable("id") Long id, Model model) {
        Optional<Transcript> optionalTranscript = transcriptRepo.findById(id);
        if (optionalTranscript.isEmpty()) {
            model.addAttribute("transcripts", List.of());
            return "fragments/transcript-result-course :: transcriptTableCourse";
        }

        Transcript transcript = optionalTranscript.get();
        List<Transcript> list = transcriptRepo.findByCourse_CourseID(transcript.getCourse().getCourseID());

        model.addAttribute("transcripts", list);
        model.addAttribute("transcript", transcript);
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", true);

        return "fragments/transcript-result-course :: transcriptTableCourse";
    }

    // Xoá transcript theo ID và courseID
    @GetMapping("/ajax-course-transcript/delete/{id}")
    public String deleteCourseTranscript(@PathVariable("id") Long id,
                                         @RequestParam("courseID") String courseID,
                                         Model model) {

        transcriptRepo.deleteById(id);

        List<Transcript> list = transcriptRepo.findByCourse_CourseID(courseID);
        model.addAttribute("transcripts", list);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result-course :: transcriptTableCourse";
    }
}
