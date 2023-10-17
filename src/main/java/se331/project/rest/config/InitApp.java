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
//        Teacher t1, t2, t3;
//        t1 = teacherRepository.save(Teacher.builder()
//                .name("Dto")
//                .surname("Dto").build());
//        t2 = teacherRepository.save(Teacher.builder()
//                .name("Kong")
//                .surname("Passakorn").build());
//        t3 = teacherRepository.save(Teacher.builder()
//                .name("Tei")
//                .surname("Pathathai").build());
//
//        Student tempStudent;
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Thiwakon")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t1);
//        t1.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Sorawee")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t1);
//        t1.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Pattanachai")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t2);
//        t2.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Taninwat")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t2);
//        t2.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Danaikrit")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t3);
//        t3.getOwnStudent().add(tempStudent);

//        addUser();
//        t1.setUser(user2);
//        user2.setTeacher(t1);
//        tempStudent.setUser(user3);
//        user3.setStudent(tempStudent);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User userT1 = new User();
        userT1.setUsername("KK");
        userT1.setPassword(encoder.encode("KK"));
        userT1.setFirstname("Kong");
        userT1.setLastname("Passakorn");
        userT1.setRoles(List.of(Role.ROLE_TEACHER));
        userRepository.save(userT1);

        Teacher teacher1 = new Teacher();
        teacher1.setUser(userT1);
        teacherRepository.save(teacher1);

        User userT2 = new User();
        userT2.setUsername("PP");
        userT2.setPassword(encoder.encode("PP"));
        userT2.setFirstname("Tei");
        userT2.setLastname("Pathathai");
        userT2.setRoles(List.of(Role.ROLE_TEACHER));
        userRepository.save(userT2);

        Teacher teacher2 = new Teacher();
        teacher2.setUser(userT2);
        teacherRepository.save(teacher2);



        User userS1 = new User();
        userS1.setUsername("student1");
        userS1.setPassword(encoder.encode("student1"));
        userS1.setFirstname("Thiwakon");
        userS1.setLastname("Sakunchao");
        userRepository.save(userS1);

        Student student1 = new Student();
        student1.setUser(userS1);
        studentRepository.save(student1);


        User userS2 = new User();
        userS2.setUsername("student2");
        userS2.setPassword(encoder.encode("student2"));
        userS2.setFirstname("Sorawee");
        userS2.setLastname("Sakunchao");
        userRepository.save(userS2);

        Student student2 = new Student();
        student2.setUser(userS2);
        studentRepository.save(student2);


        User userS3 = new User();
        userS3.setUsername("student3");
        userS3.setPassword(encoder.encode("student3"));
        userS3.setFirstname("Pattanachai");
        userS3.setLastname("Sakunchao");
        userRepository.save(userS3);

        Student student3 = new Student();
        student3.setUser(userS3);
        studentRepository.save(student3);


        User userS4 = new User();
        userS4.setUsername("student4");
        userS4.setPassword(encoder.encode("student4"));
        userS4.setFirstname("Taninwat");
        userS4.setLastname("Sakunchao");
        userRepository.save(userS4);

        Student student4 = new Student();
        student4.setUser(userS4);
        studentRepository.save(student4);


        teacher1.setUser(userT1);
        teacher1.getOwnStudent().add(student1);
        teacher1.getOwnStudent().add(student2);
        student1.setUser(userS1);
        student1.setTeacher(teacher1);
        student2.setUser(userS2);
        student2.setTeacher(teacher1);

        teacher2.setUser(userT2);
        teacher2.getOwnStudent().add(student3);
        teacher2.getOwnStudent().add(student4);
        student3.setUser(userS3);
        student3.setTeacher(teacher2);
        student4.setUser(userS4);
        student4.setTeacher(teacher2);

        User admin;
        admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .roles(List.of(Role.ROLE_ADMIN))
                .build();
        userRepository.save(admin);

    }
//    User user1, user2, user3;
//    private void addUser() {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        user1 = User.builder()
//                .username("admin")
//                .password(encoder.encode("admin"))
//                .firstname("admin")
//                .lastname("admin")
//                .email("admin@admin.com")
//                .roles(List.of(Role.ROLE_ADMIN))
//                .build();
//        user2 = User.builder()
//                .username("teacher")
//                .password(encoder.encode("teacher"))
//                .firstname("teacher")
//                .lastname("teacher")
//                .email("enabled@user.com")
//                .roles(List.of(Role.ROLE_TEACHER))
//                .build();
//        user3 = User.builder()
//                .username("student")
//                .password(encoder.encode("student"))
//                .firstname("student")
//                .lastname("student")
//                .email("disableUser@user.com")
//                .roles(List.of(Role.ROLE_STUDENT))
//                .build();
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//    }
}
