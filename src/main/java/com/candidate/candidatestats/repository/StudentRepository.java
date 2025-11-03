package com.candidate.candidatestats.repository;

import com.candidate.candidatestats.model.Student;
import com.candidate.candidatestats.model.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;

public interface StudentRepository extends JpaRepository<Student, StudentId> {

    @Query("SELECT s FROM Student s WHERE s.studentId = :studentId")
    List<Student> findByStudentId(Integer studentId);

    @Query(value = """
        SELECT r.reg_id, r.mobile_no, ROUND(AVG(st.exam_score),2) AS avg_score,
               SUM(st.exam_score) AS total_score, COUNT(st.sub_id) AS subjects_attempted
        FROM registrations r
        JOIN students st ON r.reg_id = st.student_id
        WHERE r.reg_id = :studentId
        GROUP BY r.reg_id
        """, nativeQuery = true)
    Object getOverallStats(Integer studentId);

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
}
