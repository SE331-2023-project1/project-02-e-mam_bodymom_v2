package se331.project.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;
import se331.project.rest.repository.StudentRepository;
import se331.project.rest.repository.TeacherRepository;
import org.springframework.transaction.annotation.Transactional;
import se331.project.rest.security.user.Role;
import se331.project.rest.security.user.User;
import se331.project.rest.security.user.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Teacher t1, t2, t3;
        t1 = teacherRepository.save(Teacher.builder()
                .name("Dto")
                .surname("Dto").build());
        t2 = teacherRepository.save(Teacher.builder()
                .name("Kong")
                .surname("Passakorn").build());
        t3 = teacherRepository.save(Teacher.builder()
                .name("Tei")
                .surname("Pathathai").build());

        Student tempStudent;

        tempStudent = studentRepository.save(Student.builder()
                .name("Thiwakon")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t1);
        t1.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Sorawee")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t1);
        t1.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Pattanachai")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t2);
        t2.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Taninwat")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t2);
        t2.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Danaikrit")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t3);
        t3.getOwnStudent().add(tempStudent);

        addUser();
        t1.setUser(user2);
        user2.setTeacher(t1);
        tempStudent.setUser(user3);
        user3.setStudent(tempStudent);

    }
    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .roles(List.of(Role.ROLE_ADMIN))
                .build();
        user2 = User.builder()
                .username("teacher")
                .password(encoder.encode("teacher"))
                .firstname("teacher")
                .lastname("teacher")
                .email("enabled@user.com")
                .roles(List.of(Role.ROLE_TEACHER))
                .build();
        user3 = User.builder()
                .username("student")
                .password(encoder.encode("student"))
                .firstname("student")
                .lastname("student")
                .email("disableUser@user.com")
                .roles(List.of(Role.ROLE_STUDENT))
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
