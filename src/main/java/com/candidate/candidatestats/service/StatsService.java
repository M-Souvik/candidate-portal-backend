package com.candidate.candidatestats.service;

import com.candidate.candidatestats.dto.StatsCountDTO;
import com.candidate.candidatestats.repository.StatsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;
    // private RegisRepository statsRepository;


    public StatsCountDTO getStatsCount() {
        Object[] result = (Object[]) statsRepository.getStatsCount();
        Long subjects = ((Number) result[0]).longValue();
        Long registered = ((Number) result[1]).longValue();
        Long enrolled = ((Number) result[2]).longValue();
        Long avg_score =((Number) result[3]).longValue();

        return new StatsCountDTO(subjects, registered, enrolled, avg_score);
    }

     
}
