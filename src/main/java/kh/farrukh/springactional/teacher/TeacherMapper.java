package kh.farrukh.springactional.teacher;

import kh.farrukh.springactional.teacher.dto.TeacherCreateRequestDto;
import kh.farrukh.springactional.teacher.dto.TeacherResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TeacherMapper {

  Teacher toTeacher(TeacherCreateRequestDto requestDto);

  TeacherResponseDto toResponseDto(Teacher teacher);

}
