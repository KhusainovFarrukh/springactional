package kh.farrukh.springactional.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

  boolean existsByNameIgnoreCase(String name);

}
