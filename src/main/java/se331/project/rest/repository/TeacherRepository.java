package se331.project.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;
import java.util.List;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAll();

    Page<Teacher> findByUser_FirstnameIgnoreCaseContainingOrUser_LastnameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(String name, String surname, String department, Pageable pageRequest);
}
