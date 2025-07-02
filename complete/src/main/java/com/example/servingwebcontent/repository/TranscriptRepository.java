package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
    
    List<Transcript> findByStudent_StudentId(String studentId);
    List<Transcript> findByCourse_CourseID(String courseID);
    List<Transcript> findBySemester(String semester);

}
