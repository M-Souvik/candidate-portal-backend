package com.candidate.candidatestats.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate.candidatestats.repository.ScoreRepository;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Map<String, Object>> getTotalScores() {
        return scoreRepository.getStudentTotalScores();
    }

      public List<Map<String, Object>> getScoreRangeStats() {
        return scoreRepository.getScoreRangeStats();
    }
}
