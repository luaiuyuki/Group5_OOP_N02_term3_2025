package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "grade10")
    private Float grade10;

    @Column(name = "semester", length = 50)
    private String semester;

    // === Constructors ===
    public Transcript() {}

    public Transcript(Student student, Course course, Float grade10, String semester) {
        this.student = student;
        this.course = course;
        this.grade10 = grade10;
        this.semester = semester;
    }

    // === Getters and Setters ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Float getGrade10() { return grade10; }
    public void setGrade10(Float grade10) { this.grade10 = grade10; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    // === Các phương thức quy đổi theo đúng SELECT SQL ===
    public float getGrade4() {
        if (grade10 == null) return 0.0f;
        if (grade10 >= 8.5f) return 4.0f;
        if (grade10 >= 8.0f) return 3.5f;
        if (grade10 >= 7.0f) return 3.0f;
        if (grade10 >= 6.5f) return 2.5f;
        if (grade10 >= 5.5f) return 2.0f;
        if (grade10 >= 5.0f) return 1.5f;
        if (grade10 >= 4.0f) return 1.0f;
        return 0.0f;
    }

    public String getLetterGrade() {
        if (grade10 == null) return "";
        if (grade10 >= 8.5f) return "A";
        if (grade10 >= 8.0f) return "B+";
        if (grade10 >= 7.0f) return "B";
        if (grade10 >= 6.5f) return "C+";
        if (grade10 >= 5.5f) return "C";
        if (grade10 >= 5.0f) return "D+";
        if (grade10 >= 4.0f) return "D";
        return "F";
    }

    public String getStatus() {
        if (grade10 == null) return "No Grade";
        return grade10 >= 4.0f ? "Pass" : "Fail";
    }
    
}
