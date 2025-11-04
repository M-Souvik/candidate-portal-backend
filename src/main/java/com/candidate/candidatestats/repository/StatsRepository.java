package com.candidate.candidatestats.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import com.candidate.candidatestats.model.Registrations; // Use any existing entity

@Repository
public interface StatsRepository extends CrudRepository<Registrations, Integer> {

    @Query(value = """
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
            student_id;
        SELECT 
            (SELECT COUNT(*) FROM subjects) AS subjects,
            (SELECT COUNT(*) FROM registrations) AS registered,
            (SELECT COUNT(*) FROM registrations) AS enrolled,
            (SELECT AVG(total_score) FROM student_score)
        """, nativeQuery = true)
    Object getStatsCount();


}
