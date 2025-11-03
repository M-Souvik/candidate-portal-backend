package com.candidate.candidatestats.service;

import com.candidate.candidatestats.model.Student;
import com.candidate.candidatestats.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Student> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Student addCandidate(Student candidate) {
        return candidateRepository.save(candidate);
    }
}
