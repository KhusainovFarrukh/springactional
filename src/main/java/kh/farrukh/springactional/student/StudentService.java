package kh.farrukh.springactional.student;

import kh.farrukh.springactional.student.dto.StudentCreateRequestDto;
import kh.farrukh.springactional.student.dto.StudentExamResponseDto;
import kh.farrukh.springactional.student.dto.StudentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

  Page<StudentResponseDto> getStudents(Pageable pageable);

  StudentResponseDto getStudent(Long id);

  void createStudent(StudentCreateRequestDto requestDto);

  Student findStudent(Long id);

  StudentExamResponseDto examineStudent(Long id);
}
