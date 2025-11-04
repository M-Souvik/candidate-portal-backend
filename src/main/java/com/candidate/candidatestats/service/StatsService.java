package com.candidate.candidatestats.service;

import com.candidate.candidatestats.dto.StatsCountDTO;
import com.candidate.candidatestats.repository.StatsRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void createOrReplaceView() {
        entityManager.createNativeQuery("""
            CREATE OR REPLACE VIEW student_score AS
            SELECT 
                student_id,
                ROUND(SUM(exam_score)::numeric, 2) AS total_score,
                ROUND(AVG(exam_score)::numeric, 2) AS average_score
            FROM 
                students
            GROUP BY 
                student_id
            ORDER BY 
                student_id
        """).executeUpdate();
    }

    @Transactional
    public StatsCountDTO getStatsCount() {
        // ✅ Call safely inside an active transaction
        createOrReplaceView();

        Object[] result = (Object[]) statsRepository.getStatsCount();

        Long subjects = ((Number) result[0]).longValue();
        Long registered = ((Number) result[1]).longValue();
        Long enrolled = ((Number) result[2]).longValue();
        Double avgScore = ((Number) result[3]).doubleValue();

        return new StatsCountDTO(subjects.longValue(), registered.longValue(), enrolled.longValue(), avgScore.longValue());
    }
}
