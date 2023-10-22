package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Student;
import  se331.project.rest.entity.Teacher;

import java.util.List;


public interface TeacherService {

    Integer getTeachersSize();

    Page<Teacher> getTeachers(Integer pageSize, Integer page);

    Page<Teacher> getTeachers(String filter, Pageable pageable);

    List<Teacher> getAllTeachers();

    Teacher getTeacher(Long id);

    Teacher save(Teacher teacher);

    Teacher updateDetail(Teacher teacher);

    Teacher getTeacherByStudent(Long id);
}
