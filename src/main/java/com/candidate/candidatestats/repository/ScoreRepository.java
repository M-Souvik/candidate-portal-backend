package com.candidate.candidatestats.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.candidate.candidatestats.model.Registrations;

@Repository
public interface ScoreRepository extends JpaRepository<Registrations, Integer> {

    @Query(value = """
        SELECT 
            r.reg_id AS student_id,
            SUM(s.exam_score) AS total_score,
            AVG(s.exam_score) AS average_score
        FROM registrations r
        JOIN students s ON r.reg_id = s.student_id
        GROUP BY r.reg_id
        ORDER BY r.reg_id
        """, nativeQuery = true)
    List<Map<String, Object>> getStudentTotalScores();

     @Query(value = """
        SELECT 
          CASE 
            WHEN total_score BETWEEN 0 AND 100 THEN '0 - 100'
            WHEN total_score BETWEEN 101 AND 200 THEN '101 - 200'
            WHEN total_score BETWEEN 201 AND 300 THEN '201 - 300'
            WHEN total_score BETWEEN 301 AND 400 THEN '301 - 400'
            ELSE '400+'
          END AS score_range,
          COUNT(*) AS student_count
        FROM (
          SELECT r.reg_id, SUM(s.exam_score) AS total_score
          FROM registrations r
          JOIN students s ON r.reg_id = s.student_id
          GROUP BY r.reg_id
        ) AS student_scores
        GROUP BY score_range
        ORDER BY score_range
        """, nativeQuery = true)
    List<Map<String, Object>> getScoreRangeStats();
}

