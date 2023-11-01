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

        User userS5 = new User();
        userS5.setUsername("64211501");
        userS5.setPassword(encoder.encode("64211501"));
        userS5.setFirstname("Taninwa");
        userS5.setLastname("Sakuncho");
        userS5.setRoles(List.of(Role.ROLE_STUDENT));
        userS5.setDepartment("Economic");
        userS5.setImages(Collections.singletonList("https://rebrand.ly/35uqc75"));
        userRepository.save(userS5);

        Student student5 = new Student();
        student5.setUser(userS5);
        studentRepository.save(student5);

        User userS6 = new User();
        userS6.setUsername("6421119");
        userS6.setPassword(encoder.encode("6421119"));
        userS6.setFirstname("Taninwt");
        userS6.setLastname("Sakuncao");
        userS6.setRoles(List.of(Role.ROLE_STUDENT));
        userS6.setDepartment("Ecoomics");
        userS6.setImages(Collections.singletonList("https://rebrand.ly/35uqc75"));
        userRepository.save(userS6);
        Student student6 = new Student();
        student6.setUser(userS6);
        studentRepository.save(student6);
        User userS7 = new User();
        userS7.setUsername("64115019");
        userS7.setPassword(encoder.encode("64115019"));
        userS7.setFirstname("Tawat");
        userS7.setLastname("unchao");
        userS7.setRoles(List.of(Role.ROLE_STUDENT));
        userS7.setDepartment("Econcs");
        userS7.setImages(Collections.singletonList("https://rebrand.ly/35uqc75"));
        userRepository.save(userS7);
        Student student7 = new Student();
        student7.setUser(userS7);
        studentRepository.save(student7);

        User userS8 = new User();
        userS8.setUsername("615019");
        userS8.setPassword(encoder.encode("5019"));
        userS8.setFirstname("Tawat");
        userS8.setLastname("Sakao");
        userS8.setRoles(List.of(Role.ROLE_STUDENT));
        userS8.setDepartment("Eccs");
        userS8.setImages(Collections.singletonList("https://rebrand.ly/35uqc75"));
        userRepository.save(userS8);
        Student student8 = new Student();
        student8.setUser(userS8);
        studentRepository.save(student8);

        Student student4 = new Student();
        student4.setUser(userS4);
        studentRepository.save(student4);


        teacher1.setUser(userT1);
        teacher1.getOwnStudent().add(student1);
        teacher1.getOwnStudent().add(student2);
        teacher1.getOwnStudent().get(0).setName("Thiwakon");
        teacher1.getOwnStudent().get(0).setSurname("Sakunchao");
        teacher1.getOwnStudent().get(1).setName("Thanakorn");
        teacher1.getOwnStudent().get(1).setSurname("Waleejaroenpong");
        student1.setUser(userS1);
        student1.setTeacher(teacher2);
//        student1.getTeacher().setName("Kong");
//        student1.getTeacher().setSurname("Passakorn");

        student2.setTeacher(teacher1);
        student2.getTeacher().setName("Kong");
        student2.getTeacher().setSurname("Passakorn");

        teacher2.setUser(userT2);
        teacher2.getOwnStudent().add(student3);
        teacher2.getOwnStudent().add(student4);
        teacher2.getOwnStudent().get(0).setName("Phacharanan");
        teacher2.getOwnStudent().get(0).setSurname("Thumjaikul");
        teacher2.getOwnStudent().get(1).setName("Taninwat");
        teacher2.getOwnStudent().get(1).setSurname("Sakunchao");
        student3.setUser(userS3);
        student3.setTeacher(teacher2);
        student3.getTeacher().setName("Tei");
        student3.getTeacher().setSurname("Pathathai");
        student4.setUser(userS4);
        student4.setTeacher(teacher2);
        student4.getTeacher().setName("Tei");
        student4.getTeacher().setSurname("Pathathai");
        student5.setUser(userS5);
        student5.setTeacher(teacher2);
        student5.getTeacher().setName("Tei");
        student5.getTeacher().setSurname("Pathathai");
        student6.setUser(userS6);
        student6.setTeacher(teacher2);
        student6.getTeacher().setName("Tei");
        student6.getTeacher().setSurname("Pathathai");
        student7.setUser(userS7);
        student7.setTeacher(teacher2);
        student7.getTeacher().setName("Tei");
        student7.getTeacher().setSurname("Pathathai");
        student8.setUser(userS8);
        student8.setTeacher(teacher2);
        student8.getTeacher().setName("Tei");
        student8.getTeacher().setSurname("Pathathai");

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
        files2.add("https://storage.googleapis.com/imageupload-f10a5.appspot.com/2566-11-01 002337895-Project Description.pdf");

        Announcement announcement2;
        announcement2 = Announcement.builder()
                .title("Final exam formula")
                .description("This is statistic formula for final exam.")
                .files(files2)
                .build();
        announcementRepository.save(announcement2);


    }
}
