package com.candidate.candidatestats.service;

import com.candidate.candidatestats.model.Student;
import com.candidate.candidatestats.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getScoresByStudentId(Integer studentId) {
        return repo.findByStudentId(studentId);
    }

    public Object getOverallStats(Integer studentId) {
        return repo.getOverallStats(studentId);
    }

     public List<Map<String, Object>> getTotalScores() {
        return repo.getStudentTotalScores();
    }
}
