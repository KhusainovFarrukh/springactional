package kh.farrukh.springactional.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateRequestDto {

  @NotBlank
  @Size(max = 50)
  private String name;

  @Size(max = 30)
  private String email;

  @NotNull
  private Long teacherId;

}
