package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository teacherRepository;
  private final TeacherValidator teacherValidator;
  private final TeacherMapper teacherMapper;

  @Override
  public Page<TeacherResponseDto> getTeachers(Pageable pageable) {
    return teacherRepository.findAll(pageable)
        .map(teacherMapper::toResponseDto);
  }

  @Override
  public TeacherResponseDto getTeacher(Long id) {
    return teacherMapper.toResponseDto(findTeacher(id));
  }

  @Override
  public void createTeacher(TeacherCreateRequestDto requestDto) {
    teacherValidator.beforeCreate(requestDto);
    var teacher = teacherMapper.toTeacher(requestDto);
    teacherRepository.save(teacher);
  }

  @Override
  public Teacher findTeacher(Long id) {
    return teacherRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("teacher.not_found"));
  }

}
