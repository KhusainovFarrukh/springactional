package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {

  Page<TeacherResponseDto> getTeachers(Pageable pageable);

  TeacherResponseDto getTeacher(Long id);

  void createTeacher(TeacherCreateRequestDto requestDto);

}
