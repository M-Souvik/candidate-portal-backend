package com.candidate.candidatestats.repository;

import com.candidate.candidatestats.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Student, Long> {
}
