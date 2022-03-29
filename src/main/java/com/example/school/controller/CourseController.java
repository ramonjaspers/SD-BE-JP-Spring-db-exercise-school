package com.example.school.controller;

import com.example.school.model.Course;
import com.example.school.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseRepository repos;

    public CourseController(CourseRepository repos) {
        this.repos = repos;
    }

    @GetMapping("/courses")
    public ResponseEntity<Object> getCourses() {
        List<Course> courses = repos.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Object> createCourses(@RequestBody Course course) {
        Course savedCourse = repos.save(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }
}
