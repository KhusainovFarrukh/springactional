package kh.farrukh.springactional.examlog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamLogRepository extends JpaRepository<ExamLog, Long> {

}
