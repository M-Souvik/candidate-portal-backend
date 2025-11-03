package com.candidate.candidatestats.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registrations")
public class Registrations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id")
    private Integer regId;

    @Column(name = "mobile_no", unique = true)
    private Long mobileNo;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "exam_time")
    private String examTime;
    @Column(length = 50)
    private String venue;
    private String state;
    private String city;

    // Getters & Setters
    public Integer getRegId() { return regId; }
    public void setRegId(Integer regId) { this.regId = regId; }

    public Long getMobileNo() { return mobileNo; }
    public void setMobileNo(Long mobileNo) { this.mobileNo = mobileNo; }

    public LocalDate getExamDate() { return examDate; }
    public void setExamDate(LocalDate examDate) { this.examDate = examDate; }

    public String getExamTime() { return examTime; }
    public void setExamTime(String examTime) { this.examTime = examTime; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
