package com.candidate.candidatestats.controller;

import com.candidate.candidatestats.dto.StatsCountDTO;
import com.candidate.candidatestats.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/summary")
    public StatsCountDTO getStatsCount() {
        return statsService.getStatsCount();
    }
}
