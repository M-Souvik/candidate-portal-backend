package com.candidate.candidatestats.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private Integer subId;

    @Column(name = "sub_name", unique = true)
    private String subName;

    public Integer getSubId() { return subId; }
    public void setSubId(Integer subId) { this.subId = subId; }

    public String getSubName() { return subName; }
    public void setSubName(String subName) { this.subName = subName; }
}
