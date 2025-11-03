package com.candidate.candidatestats.controller;

import com.candidate.candidatestats.model.Student;
import com.candidate.candidatestats.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")// to allow React frontend
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Student> getCandidates() {
        return candidateService.getAllCandidates();
    }

    @PostMapping
    public Student addCandidate(@RequestBody Student candidate) {
        return candidateService.addCandidate(candidate);
    }
}
