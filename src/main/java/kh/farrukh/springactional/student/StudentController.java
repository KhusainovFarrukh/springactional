package kh.farrukh.springactional.student;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import kh.farrukh.springactional.student.dto.StudentCreateRequestDto;
import kh.farrukh.springactional.student.dto.StudentExamResponseDto;
import kh.farrukh.springactional.student.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping
  @PageableAsQueryParam
  public ResponseEntity<Page<StudentResponseDto>> getStudents(
      @Schema(hidden = true) Pageable pageable
  ) {
    return ResponseEntity.ok(studentService.getStudents(pageable));
  }

  @GetMapping("{id}")
  public ResponseEntity<StudentResponseDto> getStudent(
      @PathVariable Long id
  ) {
    return ResponseEntity.ok(studentService.getStudent(id));
  }

  @PostMapping
  public ResponseEntity<Void> createStudent(
      @RequestBody @Valid StudentCreateRequestDto requestDto
  ) {
    studentService.createStudent(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("{id}/examine")
  public ResponseEntity<StudentExamResponseDto> examineStudent(
      @PathVariable Long id
  ) {
    return ResponseEntity.ok(studentService.examineStudent(id));
  }

}
