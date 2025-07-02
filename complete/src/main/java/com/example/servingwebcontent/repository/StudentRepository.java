package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
   List<Student> findByFullnameContainingIgnoreCase(String fullname);


}
