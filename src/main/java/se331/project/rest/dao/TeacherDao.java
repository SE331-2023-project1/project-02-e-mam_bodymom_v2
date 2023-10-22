package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;

public interface TeacherDao {

    Integer getTeacherSize();
    Teacher save(Teacher teacher);
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Page<Teacher> getTeachers(Pageable page);
    Teacher getTeacher(Long id);

    Page<Teacher> getTeachers(String filter, Pageable page);

}
