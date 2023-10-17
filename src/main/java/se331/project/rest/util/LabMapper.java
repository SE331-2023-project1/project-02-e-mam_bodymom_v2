package se331.project.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.project.rest.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    List<StudentDTO> getStudentDTO(List<Student> students);
    @Mapping(source = "ownStudent", target = "ownStudent")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    @Mapping(source = "teacher", target = "teacher")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    StudentDTO getStudentDTO(Student student);
}
