package com.candidate.candidatestats.repository;

import com.candidate.candidatestats.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects, Integer> {}
