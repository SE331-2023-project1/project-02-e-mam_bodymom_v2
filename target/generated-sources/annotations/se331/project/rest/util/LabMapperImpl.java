package se331.project.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.project.rest.entity.Announcement;
import se331.project.rest.entity.AnnouncementDTO;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.StudentDTO;
import se331.project.rest.entity.StudentTeacherDTO;
import se331.project.rest.entity.Teacher;
import se331.project.rest.entity.TeacherDTO;
import se331.project.rest.entity.TeacherOwnStudentDTO;
import se331.project.rest.security.user.Role;
import se331.project.rest.security.user.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2566-10-18T02:56:17+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public List<StudentDTO> getStudentDTO(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( students.size() );
        for ( Student student : students ) {
            list.add( getStudentDTO( student ) );
        }

        return list;
    }

    @Override
    public TeacherDTO getTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO.TeacherDTOBuilder teacherDTO = TeacherDTO.builder();

        teacherDTO.ownStudent( studentListToTeacherOwnStudentDTOList( teacher.getOwnStudent() ) );
        teacherDTO.username( teacherUserUsername( teacher ) );
        teacherDTO.name( teacherUserFirstname( teacher ) );
        teacherDTO.surname( teacherUserLastname( teacher ) );
        List<Role> roles = teacherUserRoles( teacher );
        List<Role> list1 = roles;
        if ( list1 != null ) {
            teacherDTO.roles( new ArrayList<Role>( list1 ) );
        }
        teacherDTO.id( teacher.getId() );
        List<String> list2 = teacher.getImages();
        if ( list2 != null ) {
            teacherDTO.images( new ArrayList<String>( list2 ) );
        }
        teacherDTO.department( teacher.getDepartment() );

        return teacherDTO.build();
    }

    @Override
    public List<TeacherDTO> getTeacherDTO(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDTO> list = new ArrayList<TeacherDTO>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( getTeacherDTO( teacher ) );
        }

        return list;
    }

    @Override
    public StudentDTO getStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.teacher( teacherToStudentTeacherDTO( student.getTeacher() ) );
        studentDTO.username( studentUserUsername( student ) );
        studentDTO.name( studentUserFirstname( student ) );
        studentDTO.surname( studentUserLastname( student ) );
        List<Role> roles = studentUserRoles( student );
        List<Role> list = roles;
        if ( list != null ) {
            studentDTO.roles( new ArrayList<Role>( list ) );
        }
        studentDTO.id( student.getId() );
        List<String> list1 = student.getImages();
        if ( list1 != null ) {
            studentDTO.images( new ArrayList<String>( list1 ) );
        }
        studentDTO.department( student.getDepartment() );

        return studentDTO.build();
    }

    @Override
    public AnnouncementDTO getAnnouncementDTO(Announcement announcement) {
        if ( announcement == null ) {
            return null;
        }

        AnnouncementDTO.AnnouncementDTOBuilder announcementDTO = AnnouncementDTO.builder();

        announcementDTO.id( announcement.getId() );
        announcementDTO.title( announcement.getTitle() );
        announcementDTO.description( announcement.getDescription() );

        return announcementDTO.build();
    }

    @Override
    public List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcement) {
        if ( announcement == null ) {
            return null;
        }

        List<AnnouncementDTO> list = new ArrayList<AnnouncementDTO>( announcement.size() );
        for ( Announcement announcement1 : announcement ) {
            list.add( getAnnouncementDTO( announcement1 ) );
        }

        return list;
    }

    protected TeacherOwnStudentDTO studentToTeacherOwnStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        TeacherOwnStudentDTO.TeacherOwnStudentDTOBuilder teacherOwnStudentDTO = TeacherOwnStudentDTO.builder();

        teacherOwnStudentDTO.id( student.getId() );
        teacherOwnStudentDTO.name( student.getName() );
        teacherOwnStudentDTO.surname( student.getSurname() );

        return teacherOwnStudentDTO.build();
    }

    protected List<TeacherOwnStudentDTO> studentListToTeacherOwnStudentDTOList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<TeacherOwnStudentDTO> list1 = new ArrayList<TeacherOwnStudentDTO>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToTeacherOwnStudentDTO( student ) );
        }

        return list1;
    }

    private String teacherUserUsername(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }
        User user = teacher.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String teacherUserFirstname(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }
        User user = teacher.getUser();
        if ( user == null ) {
            return null;
        }
        String firstname = user.getFirstname();
        if ( firstname == null ) {
            return null;
        }
        return firstname;
    }

    private String teacherUserLastname(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }
        User user = teacher.getUser();
        if ( user == null ) {
            return null;
        }
        String lastname = user.getLastname();
        if ( lastname == null ) {
            return null;
        }
        return lastname;
    }

    private List<Role> teacherUserRoles(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }
        User user = teacher.getUser();
        if ( user == null ) {
            return null;
        }
        List<Role> roles = user.getRoles();
        if ( roles == null ) {
            return null;
        }
        return roles;
    }

    protected StudentTeacherDTO teacherToStudentTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        StudentTeacherDTO.StudentTeacherDTOBuilder studentTeacherDTO = StudentTeacherDTO.builder();

        studentTeacherDTO.id( teacher.getId() );
        studentTeacherDTO.name( teacher.getName() );

        return studentTeacherDTO.build();
    }

    private String studentUserUsername(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String studentUserFirstname(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        String firstname = user.getFirstname();
        if ( firstname == null ) {
            return null;
        }
        return firstname;
    }

    private String studentUserLastname(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        String lastname = user.getLastname();
        if ( lastname == null ) {
            return null;
        }
        return lastname;
    }

    private List<Role> studentUserRoles(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        List<Role> roles = user.getRoles();
        if ( roles == null ) {
            return null;
        }
        return roles;
    }
}
