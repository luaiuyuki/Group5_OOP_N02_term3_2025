package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
  List<Course> findByCourseNameContainingIgnoreCase(String courseName);


}
