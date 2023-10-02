package kh.farrukh.springactional.teacher.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResponseDto {

  private Long id;

  private String name;

  private Long salary;

  private Long actualSalary;

}
