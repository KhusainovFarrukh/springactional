package kh.farrukh.springactional.student;

import kh.farrukh.springactional.student.dto.StudentCreateRequestDto;
import kh.farrukh.springactional.student.dto.StudentResponseDto;
import kh.farrukh.springactional.teacher.TeacherMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.SPRING,
    uses = TeacherMapper.class
)
public interface StudentMapper {

  Student toStudent(StudentCreateRequestDto requestDto);

  StudentResponseDto toResponseDto(Student student);

}
