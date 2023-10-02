package kh.farrukh.springactional.student;

import java.util.Random;
import kh.farrukh.springactional.examlog.ExamLog;
import kh.farrukh.springactional.student.dto.StudentCreateRequestDto;
import kh.farrukh.springactional.student.dto.StudentExamResponseDto;
import kh.farrukh.springactional.student.dto.StudentResponseDto;
import kh.farrukh.springactional.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;
  private final StudentValidator studentValidator;

  private final TeacherService teacherService;
  private final Random random = new Random();

  private static final Long EXAM_MAX_RESULT = 100L;

  @Override
  public Page<StudentResponseDto> getStudents(Pageable pageable) {
    return studentRepository.findAll(pageable)
        .map(studentMapper::toResponseDto);
  }

  @Override
  public StudentResponseDto getStudent(Long id) {
    return studentMapper.toResponseDto(findStudent(id));
  }

  @Override
  public void createStudent(StudentCreateRequestDto requestDto) {
    studentValidator.beforeCreate(requestDto);
    var student = studentMapper.toStudent(requestDto);
    student.setTeacher(teacherService.findTeacher(requestDto.getTeacherId()));
    studentRepository.save(student);
  }

  @Override
  public Student findStudent(Long id) {
    return studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("student.not_found"));
  }

  @Override
  @Transactional
  public StudentExamResponseDto examineStudent(Long id) {
    var student = findStudent(id);

    var result = getRandomResult();

    student.setLastResult(result);
    new ExamLog(student.getName(), student.getTeacher().getName(), result);
    teacherService.changeBonusAccordingToExamResult(student.getTeacher().getId(), result);

    return new StudentExamResponseDto(student.getName(), result);
  }

  private Long getRandomResult() {
    return random.nextLong(EXAM_MAX_RESULT);
  }

}
