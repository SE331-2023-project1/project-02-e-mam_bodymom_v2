package se331.project.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.project.rest.entity.Announcement;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;
import se331.project.rest.repository.AnnouncementRepository;
import se331.project.rest.repository.StudentRepository;
import se331.project.rest.repository.TeacherRepository;
import org.springframework.transaction.annotation.Transactional;
import se331.project.rest.security.user.Role;
import se331.project.rest.security.user.User;
import se331.project.rest.security.user.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;
    final AnnouncementRepository announcementRepository;
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
        userT1.setDepartment("Software Engineer");
        userT1.setAcademic("PhD");
        userT1.setImages(Collections.singletonList("https://shorturl.at/qzH69"));
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
        userT2.setDepartment("Software Engineer");
        userT2.setAcademic("PhD");
        userT2.setImages(Collections.singletonList("https://shorturl.at/bhjVY"));
        userRepository.save(userT2);

        Teacher teacher2 = new Teacher();
        teacher2.setUser(userT2);
        teacherRepository.save(teacher2);



        User userS1 = new User();
        userS1.setUsername("642115020");
        userS1.setPassword(encoder.encode("642115020"));
        userS1.setFirstname("Thiwakon");
        userS1.setLastname("Sakunchao");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setDepartment("Software Engineer");
        userS1.setImages(Collections.singletonList("https://rebrand.ly/xz81uz9"));
        userRepository.save(userS1);

        Student student1 = new Student();
        student1.setUser(userS1);
        student1.setTeacher(teacher1);
        studentRepository.save(student1);


        User userS2 = new User();
        userS2.setUsername("642115021");
        userS2.setPassword(encoder.encode("642115021"));
        userS2.setFirstname("Thanakorn");
        userS2.setLastname("Waleejaroenpong");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setDepartment("Software Engineer");
        userS2.setImages(Collections.singletonList("https://rb.gy/1jp8m"));
        userRepository.save(userS2);

        Student student2 = new Student();
        student2.setUser(userS2);
        studentRepository.save(student2);


        User userS3 = new User();
        userS3.setUsername("642115026");
        userS3.setPassword(encoder.encode("642115026"));
        userS3.setFirstname("Phacharanan");
        userS3.setLastname("Thumjaikul");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setDepartment("Software Engineer");
        userS3.setImages(Collections.singletonList("https://rebrand.ly/nvnjnhm"));
        userRepository.save(userS3);

        Student student3 = new Student();
        student3.setUser(userS3);
        studentRepository.save(student3);


        User userS4 = new User();
        userS4.setUsername("642115019");
        userS4.setPassword(encoder.encode("642115019"));
        userS4.setFirstname("Taninwat");
        userS4.setLastname("Sakunchao");
        userS4.setRoles(List.of(Role.ROLE_STUDENT));
        userS4.setDepartment("Economics");
        userS4.setImages(Collections.singletonList("https://rebrand.ly/35uqc75"));
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

        //Test mapping between user id and teacher id
//        User userT3 = new User();
//        userT3.setUsername("OO");
//        userT3.setPassword(encoder.encode("OO"));
//        userT3.setFirstname("Tei");
//        userT3.setLastname("Pattama");
//        userT3.setRoles(List.of(Role.ROLE_TEACHER));
//        userT3.setDepartment("Software Engineer");
//        userRepository.save(userT3);
//
//        Teacher teacher3 = new Teacher();
//        teacher3.setUser(userT3);
//        teacherRepository.save(teacher3);
//
//        teacher3.setUser(userT3);
//        teacher3.getOwnStudent().add(student1);
//        teacher3.getOwnStudent().add(student2);
//        student1.setUser(userS1);
//        student1.setTeacher(teacher3);
//        student2.setUser(userS2);
//        student2.setTeacher(teacher3);
        //

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

        List<String> files = new ArrayList<>();

        files.add("https://rb.gy/1jp8m");
        files.add("https://rebrand.ly/xz81uz9");

        Announcement announcement;
        announcement = Announcement.builder()
                .title("Final Exam")
                .description("Final Exam is tomorrow.")
                .files(files)
                .build();
        announcementRepository.save(announcement);

        List<String> files2 = new ArrayList<>();
        files2.add("https://storage.googleapis.com/download/storage/v1/b/imageupload-f10a5.appspot.com/o/2566-10-23%20040102232-263Final-Formula.pdf?generation=1698008463101860&alt=media");

        Announcement announcement2;
        announcement2 = Announcement.builder()
                .title("Final exam formula")
                .description("This is statistic formula for final exam.")
                .files(files2)
                .build();
        announcementRepository.save(announcement2);

//        User userOP = new User();
//        userOP.setUsername("oo");
//        userOP.setPassword(encoder.encode("oo"));
//        userOP.setFirstname("PP");
//        userOP.setLastname("PP");
//        userOP.setRoles(List.of(Role.ROLE_STUDENT));
//        userOP.setDepartment("PP");
//        userRepository.save(userOP);
//
//        Student studentOP = new Student();
//        studentOP.setUser(userOP);
//        studentRepository.save(studentOP);
//        teacher1.getOwnStudent().add(studentOP);
//        studentOP.setTeacher(teacher1);

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
