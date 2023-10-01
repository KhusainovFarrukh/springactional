package kh.farrukh.springactional.teacher;

import jakarta.validation.Valid;
import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

  private final TeacherService teacherService;

  @PostMapping
  public ResponseEntity<Void> createTeacher(
      @RequestBody @Valid TeacherCreateRequestDto requestDto
  ) {
    teacherService.createTeacher(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
