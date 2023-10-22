package se331.project.rest.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import se331.project.rest.entity.Student;
import  se331.project.rest.entity.Teacher;
import se331.project.rest.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    final TeacherService teacherService;

    @GetMapping("teachers")
    public ResponseEntity<?> getTeacherLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page,
                                             @RequestParam(value = "filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Teacher> pageOutput;
        if (filter == null) {
            pageOutput = teacherService.getTeachers(perPage,page);
        }else{
            pageOutput = teacherService.getTeachers(filter, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getTeacherDTO(pageOutput.getContent()),responseHeader, HttpStatus.OK);
    }
    @GetMapping("AllTeachers")
    public ResponseEntity<?> getTeachers(@RequestParam(value = "_limit", required = false) Integer perPage,
                                         @RequestParam(value = "_page", required = false) Integer page,
                                         @RequestParam(value = "filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Teacher> pageOutput;
        if (filter == null) {
            pageOutput = teacherService.getTeachers(perPage,page);
        }else{
            pageOutput = teacherService.getTeachers(filter, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(teacherService.getAllTeachers()));
    }

    @PutMapping("updateteachers")
    public ResponseEntity<?> updateTeacherDetails(@RequestBody Teacher teacher)
    {
        return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(teacherService.updateDetail(teacher)));
    }

    @GetMapping("teachers/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable("id") Long id) {
        Teacher output = teacherService.getTeacher(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @GetMapping("teacherByStudent/{id}")
    public ResponseEntity<?> getTeacherByStudent(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherByStudent(id);
        if (teacher != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(teacher));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
