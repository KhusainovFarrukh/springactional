package kh.farrukh.springactional.teacher;

import static kh.farrukh.springactional.teacher.TeacherService.BONUS_SALARY_MULTIPLIER;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TeacherMapper {

  Teacher toTeacher(TeacherCreateRequestDto requestDto);

  @Mapping(target = "actualSalary", expression = "java(getActualSalary(teacher))")
  TeacherResponseDto toResponseDto(Teacher teacher);

  default Long getActualSalary(Teacher teacher) {
    var actualSalary = teacher.getSalary();
    if (Boolean.TRUE.equals(teacher.getHasBonus())) {
      actualSalary = Math.round(actualSalary * BONUS_SALARY_MULTIPLIER);
    }
    return actualSalary;
  }

}
