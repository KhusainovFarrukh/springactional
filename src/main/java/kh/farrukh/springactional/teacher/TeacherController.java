package kh.farrukh.springactional.teacher;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
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
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

  private final TeacherService teacherService;

  @GetMapping
  @PageableAsQueryParam
  public ResponseEntity<Page<TeacherResponseDto>> getTeachers(
      @Schema(hidden = true) Pageable pageable
  ) {
    return ResponseEntity.ok(teacherService.getTeachers(pageable));
  }

  @GetMapping("{id}")
  public ResponseEntity<TeacherResponseDto> getTeacher(
      @PathVariable Long id
  ) {
    return ResponseEntity.ok(teacherService.getTeacher(id));
  }

  @PostMapping
  public ResponseEntity<Void> createTeacher(
      @RequestBody @Valid TeacherCreateRequestDto requestDto
  ) {
    teacherService.createTeacher(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
