package com.candidate.candidatestats.service;

import com.candidate.candidatestats.model.Subjects;
import com.candidate.candidatestats.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository repo;

    public SubjectService(SubjectRepository repo) {
        this.repo = repo;
    }

    public List<Subjects> getAllSubjects() {
        return repo.findAll();
    }
}
