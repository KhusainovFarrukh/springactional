package kh.farrukh.springactional.teacher.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherCreateRequestDto {

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotNull
  @PositiveOrZero
  private Long salary;

}
