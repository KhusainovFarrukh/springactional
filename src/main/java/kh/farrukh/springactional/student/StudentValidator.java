package kh.farrukh.springactional.student;

import kh.farrukh.springactional.student.dto.StudentCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentValidator {

  private final StudentRepository studentRepository;

  public void beforeCreate(StudentCreateRequestDto requestDto) {
    checkNameUniqueness(requestDto.getName());
  }

  private void checkNameUniqueness(String name) {
    if (studentRepository.existsByNameIgnoreCase(name)) {
      throw new RuntimeException("student.name_exists");
    }
  }

}
