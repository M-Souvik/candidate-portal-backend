package com.candidate.candidatestats.model;

import java.io.Serializable;
import java.util.Objects;

public class StudentId implements Serializable {
    private Integer studentId;
    private Integer subId;

    public StudentId() {}

    public StudentId(Integer studentId, Integer subId) {
        this.studentId = studentId;
        this.subId = subId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentId)) return false;
        StudentId that = (StudentId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(subId, that.subId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subId);
    }
}
