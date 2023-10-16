package se331.project.rest.util;

import org.mapstruct.factory.Mappers;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.StudentDTO;

import java.util.List;

public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
}
