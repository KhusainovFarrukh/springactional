package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {

  Double BONUS_SALARY_MULTIPLIER = 1.1;
  Long MINIMUM_RESULT_FOR_BONUS = 51L;

  Page<TeacherResponseDto> getTeachers(Pageable pageable);

  TeacherResponseDto getTeacher(Long id);

  void createTeacher(TeacherCreateRequestDto requestDto);

  Teacher findTeacher(Long id);

  void changeBonusAccordingToExamResult(Teacher teacher, Long result);

}
