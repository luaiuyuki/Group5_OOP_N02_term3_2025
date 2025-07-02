package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id", nullable = false, unique = true)
    private String studentId;
    private String fullname;
    private String gender;
    private String dateOfBirth;
    private String major;

    public Student() {}

    public Student(String studentId, String fullname, String gender, String dateOfBirth, String major) {
        this.studentId = studentId;
        this.fullname = fullname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
