package se331.project.rest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;
import se331.project.rest.security.user.User;
import se331.project.rest.security.user.UserRepository;
import se331.project.rest.security.user.UserService;
import se331.project.rest.service.StudentService;
import se331.project.rest.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    final UserService userService;
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page,
                                             @RequestParam(value = "filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        if (filter == null) {
            pageOutput = studentService.getStudents(perPage,page);
        }else{
            pageOutput = studentService.getStudents(filter, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);
    }
    @GetMapping("AllStudents")
    public ResponseEntity<?> getStudents(@RequestParam(value = "_limit", required = false) Integer perPage,
                                         @RequestParam(value = "_page", required = false) Integer page,
                                         @RequestParam(value = "filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        if (filter == null) {
            pageOutput = studentService.getStudents(perPage,page);
        }else{
            pageOutput = studentService.getStudents(filter, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(studentService.getAllStudents()));
    }

    @PutMapping("updatestudents")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateStudentDetails(@RequestBody Student student)
    {
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(studentService.updateDetail(student)));
    }

    @GetMapping("studentsByTeacher/{id}")
    public ResponseEntity<?> getStudentsByTeacher(@PathVariable Long id) {
        List<Student> student = studentService.getStudentsByTeacher(id);
        if (student != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(student));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student output = studentService.getStudent(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

}

