package com.candidate.candidatestats.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
@IdClass(StudentId.class)
public class Student {

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Id
    @Column(name = "sub_id")
    private Integer subId;

    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(name = "exam_score")
    private Float examScore;

    // Getters and setters
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getSubId() { return subId; }
    public void setSubId(Integer subId) { this.subId = subId; }

    public Long getMobileNo() { return mobileNo; }
    public void setMobileNo(Long mobileNo) { this.mobileNo = mobileNo; }

    public Float getExamScore() { return examScore; }
    public void setExamScore(Float examScore) { this.examScore = examScore; }
}
