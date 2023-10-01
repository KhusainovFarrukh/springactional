package kh.farrukh.springactional.student.dto;

import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDto {

  private Long id;

  private String name;

  private String email;

  private TeacherResponseDto teacher;

}
