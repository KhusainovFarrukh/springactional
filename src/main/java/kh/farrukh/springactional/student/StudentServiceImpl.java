package kh.farrukh.springactional.student;

import kh.farrukh.springactional.student.dto.StudentCreateRequestDto;
import kh.farrukh.springactional.student.dto.StudentResponseDto;
import kh.farrukh.springactional.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;
  private final StudentValidator studentValidator;

  private final TeacherService teacherService;

  @Override
  public Page<StudentResponseDto> getStudents(Pageable pageable) {
    return studentRepository.findAll(pageable)
        .map(studentMapper::toResponseDto);
  }

  @Override
  public StudentResponseDto getStudent(Long id) {
    return studentRepository.findById(id)
        .map(studentMapper::toResponseDto)
        .orElseThrow(() -> new RuntimeException("student.not_found"));
  }

  @Override
  public void createStudent(StudentCreateRequestDto requestDto) {
    studentValidator.beforeCreate(requestDto);
    var student = studentMapper.toStudent(requestDto);
    student.setTeacher(teacherService.findTeacher(requestDto.getTeacherId()));
    studentRepository.save(student);
  }

}
