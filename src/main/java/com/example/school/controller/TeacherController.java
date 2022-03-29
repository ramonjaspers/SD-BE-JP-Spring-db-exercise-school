package com.example.school.controller;

import com.example.school.dto.TeacherDto;
import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/teachers")
    public ResponseEntity<Object> getTeachers() {
        List<TeacherDto> teachers = service.getTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody TeacherDto teacher, BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        service.createTeacher(teacher);
        return new ResponseEntity<>("Teacher created", HttpStatus.CREATED);
    }

    @GetMapping("/teachers/{id}/courses")
    public ResponseEntity<Object> getTeacherCourses(@PathVariable(name = "id") Long teacherId) {
        Teacher teacher = service.getTeacher(teacherId);
        return new ResponseEntity<>(teacher.getCourses(), HttpStatus.OK);
    }

}
