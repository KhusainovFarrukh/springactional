package kh.farrukh.springactional.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  boolean existsByNameIgnoreCase(String name);

  @Modifying
  @Query("""
      update Student student
      set student.lastResult = :#{#result}
      where student.id = :#{#id}
      """)
  void updateLastResult(Long id, Long result);
}
