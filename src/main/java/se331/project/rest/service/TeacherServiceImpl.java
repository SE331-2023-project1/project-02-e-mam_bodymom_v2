package se331.project.rest.service;

import se331.project.rest.dao.StudentDao;
import se331.project.rest.dao.TeacherDao;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.security.user.UserDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    final TeacherDao teacherDao;
    final StudentDao studentDao;
    final UserDao userDao;
    @Override
    public Integer getTeachersSize() {
        return teacherDao.getTeacherSize();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherDao.getTeachers(pageSize, page);
    }

    @Override
    public Page<Teacher> getTeachers(String filter, Pageable pageable) {
        return teacherDao.getTeachers(filter,pageable);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getTeachers(Pageable.unpaged()).getContent();
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherDao.getTeacher(id);
    }

    @Override
    public Teacher getTeacherByStudent(Long id) {
        return studentDao.getStudent(id).getTeacher();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public Teacher updateDetail(Teacher teacher) {
        Teacher updateTeacher = teacherDao.getTeacher(teacher.getId());
        if (updateTeacher != null) {

            updateTeacher.getUser().setFirstname(teacher.getName());
            updateTeacher.getUser().setLastname(teacher.getSurname());
            updateTeacher.getUser().setImages(teacher.getImages());
//            updateTeacher.getUser().setDepartment(teacher.getDepartment());

            teacherDao.save(updateTeacher);

            userDao.save(updateTeacher.getUser());
            return updateTeacher;
        }
        return null;
    }
}
