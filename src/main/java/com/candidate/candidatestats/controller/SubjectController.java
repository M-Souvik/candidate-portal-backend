package com.candidate.candidatestats.controller;

import com.candidate.candidatestats.model.Subjects;
import com.candidate.candidatestats.service.SubjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Subjects> getAll() {
        return service.getAllSubjects();
    }
}
