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
public class AjaxTranscriptController {

    private final TranscriptRepository transcriptRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public AjaxTranscriptController(TranscriptRepository transcriptRepo,
                                    StudentRepository studentRepo,
                                    CourseRepository courseRepo) {
        this.transcriptRepo = transcriptRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    // Trang chứa hộp tìm kiếm sinh viên
    @GetMapping("/search-student")
    public String searchStudentPage() {
        return "search-student";
    }

    // Lấy danh sách bảng điểm theo studentId và trả về fragment
    @GetMapping("/transcripts/search")
    public String getTranscriptByStudentId(@RequestParam("studentId") String studentId, Model model) {
        List<Transcript> transcripts = transcriptRepo.findByStudent_StudentId(studentId);

        model.addAttribute("transcripts", transcripts);
        model.addAttribute("transcript", new Transcript());
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result :: transcriptTable";
    }

    // Lưu hoặc cập nhật transcript
    @PostMapping("/ajax-transcript/save")
    public String saveAjaxTranscript(@ModelAttribute Transcript transcript,
                                     @RequestParam("editing") boolean editing,
                                     Model model) {

        Optional<Student> student = studentRepo.findById(transcript.getStudent().getStudentId());
        Optional<Course> course = courseRepo.findById(transcript.getCourse().getCourseID());

        if (student.isEmpty() || course.isEmpty()) {
            model.addAttribute("transcripts", List.of());
            return "fragments/transcript-result :: transcriptTable";
        }

        transcript.setStudent(student.get());
        transcript.setCourse(course.get());

        if (editing && transcript.getId() != null) {
            // Cập nhật bản ghi cũ
            transcriptRepo.findById(transcript.getId()).ifPresent(existing -> {
                existing.setGrade10(transcript.getGrade10());
                existing.setSemester(transcript.getSemester());
                existing.setStudent(transcript.getStudent());
                existing.setCourse(transcript.getCourse());
                transcriptRepo.save(existing);
            });
        } else {
            // Thêm mới
            transcriptRepo.save(transcript);
        }

        // Sau khi thêm/sửa, reload danh sách bảng điểm của sinh viên đó
        List<Transcript> updatedList = transcriptRepo.findByStudent_StudentId(transcript.getStudent().getStudentId());

        model.addAttribute("transcripts", updatedList);
        model.addAttribute("transcript", new Transcript()); // clear form
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result :: transcriptTable";
    }

    // Gọi khi bấm nút sửa
    @GetMapping("/ajax-transcript/edit/{id}")
    public String editAjaxTranscript(@PathVariable("id") Long id, Model model) {
        Optional<Transcript> optionalTranscript = transcriptRepo.findById(id);
        if (optionalTranscript.isEmpty()) {
            model.addAttribute("transcripts", List.of());
            return "fragments/transcript-result :: transcriptTable";
        }

        Transcript transcript = optionalTranscript.get();
        List<Transcript> list = transcriptRepo.findByStudent_StudentId(transcript.getStudent().getStudentId());

        model.addAttribute("transcripts", list);
        model.addAttribute("transcript", transcript);
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", true);

        return "fragments/transcript-result :: transcriptTable";
    }

    // Xóa bản ghi
    @GetMapping("/ajax-transcript/delete/{id}")
    public String deleteAjaxTranscript(@PathVariable("id") Long id,
                                       @RequestParam("studentId") String studentId,
                                       Model model) {

        transcriptRepo.deleteById(id);

        List<Transcript> list = transcriptRepo.findByStudent_StudentId(studentId);
        model.addAttribute("transcripts", list);
        model.addAttribute("transcript", new Transcript()); // reset form
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("editing", false);

        return "fragments/transcript-result :: transcriptTable";
    }
     

}
