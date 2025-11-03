package com.candidate.candidatestats.dto;

public class StatsCountDTO {
    private Long subjects;
    private Long registered;
    private Long enrolled;
    private Long avg_score;


    public StatsCountDTO(Long subjects, Long registered, Long enrolled, Long avg_score) {
        this.subjects = subjects;
        this.registered = registered;
        this.enrolled = enrolled;
        this.avg_score=avg_score;
    }

    public Long getAvg() {
        return avg_score;
    }

    public Long getSubjects() {
        return subjects;
    }

    public Long getRegistered() {
        return registered;
    }

    public Long getEnrolled() {
        return enrolled;
    }
}
