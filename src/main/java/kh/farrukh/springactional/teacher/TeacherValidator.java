package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherValidator {

  private final TeacherRepository teacherRepository;

  public void beforeCreate(TeacherCreateRequestDto requestDto) {
    checkNameUniqueness(requestDto.getName());
  }

  private void checkNameUniqueness(String name) {
    if (teacherRepository.existsByNameIgnoreCase(name)) {
      throw new RuntimeException("teacher.name_exists");
    }
  }

}
