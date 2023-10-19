package se331.project.rest.dao;

import se331.project.rest.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface StudentDao {

    Integer getStudentSize();
    Student save(Student student);
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(Pageable page);
    Student getStudent(Long id);


}
