package com.example.school.controller;

import com.example.school.model.Teacher;
import com.example.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository repos;

    @GetMapping("/teachers")
    public ResponseEntity<Object> getTeachers() {
        List<Teacher> teachers = repos.findAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody Teacher teacher, BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        repos.save(teacher);
        return new ResponseEntity<>("Teacher created", HttpStatus.CREATED);
    }
}
