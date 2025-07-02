package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "course_id", length = 50)
    private String courseID;

    @Column(name = "course_name", length = 100, nullable = false)
    private String courseName;

    @Column(name = "credits", nullable = false)
    private int credits;

    // "Ongoing" hoặc "Completed"
    @Column(name = "status", length = 20)
    private String status;

    public Course() {
    }

    public Course(String courseID, String courseName, int credits, String status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.status = status;
    }

    // Getters
    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
