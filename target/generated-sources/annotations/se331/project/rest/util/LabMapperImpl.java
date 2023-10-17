package se331.project.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.StudentDTO;
import se331.project.rest.entity.StudentTeacherDTO;
import se331.project.rest.entity.Teacher;
import se331.project.rest.entity.TeacherDTO;
import se331.project.rest.entity.TeacherOwnStudentDTO;
import se331.project.rest.security.user.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2566-10-18T00:19:00+0700",
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
        teacherDTO.id( teacher.getId() );
        List<String> list1 = teacher.getImages();
        if ( list1 != null ) {
            teacherDTO.images( new ArrayList<String>( list1 ) );
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
        studentDTO.id( student.getId() );
        List<String> list = student.getImages();
        if ( list != null ) {
            studentDTO.images( new ArrayList<String>( list ) );
        }
        studentDTO.department( student.getDepartment() );

        return studentDTO.build();
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
}
