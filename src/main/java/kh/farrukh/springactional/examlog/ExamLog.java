package kh.farrukh.springactional.examlog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "exam_logs")
@EntityListeners(AuditingEntityListener.class)
public class ExamLog {

  private static final String GENERATOR_NAME = "exam_logs_gen";
  private static final String SEQUENCE_NAME = "exam_logs_seq";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
  @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
  private Long id;

  @Column(name = "student_name", nullable = false, length = 50)
  private String studentName;

  @Column(name = "teacher_name", nullable = false, length = 50)
  private String teacherName;

  @Column(name = "result", nullable = false)
  private Long result;

  @CreatedDate
  @Column(name = "examined_at", nullable = false)
  private LocalDateTime examinedAt;

  public ExamLog(String studentName, String teacherName, Long result) {
    this.studentName = studentName;
    this.teacherName = teacherName;
    this.result = result;
  }
}
