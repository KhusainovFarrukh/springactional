package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository teacherRepository;
  private final TeacherValidator teacherValidator;
  private final TeacherMapper teacherMapper;

  @Override
  public void createTeacher(TeacherCreateRequestDto requestDto) {
    teacherValidator.beforeCreate(requestDto);
    var student = teacherMapper.toTeacher(requestDto);
    teacherRepository.save(student);
  }

}
