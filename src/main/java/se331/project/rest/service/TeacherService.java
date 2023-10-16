package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import  se331.project.rest.entity.Teacher;

import java.util.List;


public interface TeacherService {

    Integer getTeachersSize();

    Page<Teacher> getTeachers(Integer pageSize, Integer page);

    List<Teacher> getAllTeachers();

    Teacher getTeacher(Long id);

    Teacher save(Teacher teacher);
}
