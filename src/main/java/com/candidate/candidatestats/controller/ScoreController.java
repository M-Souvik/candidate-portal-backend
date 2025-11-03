package com.candidate.candidatestats.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.candidatestats.service.ScoreService;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://candidate-portal-frontend.vercel.app"
    },allowCredentials = "true")

public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getStudentTotals() {
        return ResponseEntity.ok(scoreService.getTotalScores());
    }

    @GetMapping("/range")
    public ResponseEntity<List<Map<String, Object>>> getScoreRangeStats() {
        return ResponseEntity.ok(scoreService.getScoreRangeStats());
    }
}

