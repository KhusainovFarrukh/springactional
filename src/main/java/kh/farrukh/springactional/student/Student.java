package kh.farrukh.springactional.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import kh.farrukh.springactional.teacher.Teacher;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
    name = "students",
    uniqueConstraints = @UniqueConstraint(name = "uk_students_name", columnNames = "name")
)
public class Student {

  private static final String GENERATOR_NAME = "students_gen";
  private static final String SEQUENCE_NAME = "students_seq";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
  @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
  private Long id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "email", length = 30)
  private String email;

  @Column(name = "last_result")
  private Long lastResult;

  @ManyToOne(optional = false)
  @JoinColumn(name = "teacher_id", nullable = false)
  private Teacher teacher;

}
