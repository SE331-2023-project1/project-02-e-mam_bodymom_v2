package se331.project.rest.repository;

import se331.project.rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    

}
