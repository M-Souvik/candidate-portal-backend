package com.candidate.candidatestats.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import com.candidate.candidatestats.model.Registrations; // Use any existing entity

@Repository
public interface StatsRepository extends CrudRepository<Registrations, Integer> {

    @Query(value = """
        SELECT 
            (SELECT COUNT(*) FROM subjects) AS subjects,
            (SELECT COUNT(*) FROM registrations) AS registered,
            (SELECT COUNT(*) FROM registrations) AS enrolled,
            (SELECT AVG(total_score) FROM student_score)
        """, nativeQuery = true)
    Object getStatsCount();


}
