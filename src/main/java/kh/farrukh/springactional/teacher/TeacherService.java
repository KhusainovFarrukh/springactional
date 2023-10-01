package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;

public interface TeacherService {

  void createTeacher(TeacherCreateRequestDto requestDto);

}
