package com.candidate.candidatestats.repository;

import com.candidate.candidatestats.model.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registrations, Integer> {
    Optional<Registrations> findByMobileNo(Long mobileNo);
    long count();
        // Count registrations grouped by state (optional)
    @Query("SELECT r.state AS state, COUNT(r) AS totalRegistrations " +
           "FROM Registrations r " +
           "GROUP BY r.state")
    List<Object[]> getRegistrationsCountByState();

      @Query(value = """
        SELECT 
            TO_CHAR(exam_date, 'Month') AS month,
            COUNT(*) AS count
        FROM registrations
        GROUP BY TO_CHAR(exam_date, 'Month'), EXTRACT(MONTH FROM exam_date)
        ORDER BY EXTRACT(MONTH FROM exam_date)
        """, nativeQuery = true)
    List<Object[]> getMonthlyRegistrationStats();
}
