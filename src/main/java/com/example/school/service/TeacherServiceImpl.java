package com.example.school.service;

import com.example.school.dto.TeacherDto;
import com.example.school.model.Teacher;
import com.example.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repos;

    public TeacherServiceImpl(TeacherRepository repos) {
        this.repos = repos;
    }

    @Override
    public List<TeacherDto> getTeachers() {
        List<Teacher> repoTeachers = this.repos.findAll();
        List<TeacherDto> teachers = new ArrayList<>();

        repoTeachers.forEach(repoTeacher -> teachers.add(
                new TeacherDto(
                        repoTeacher.getId(),
                        repoTeacher.getFirstName(),
                        repoTeacher.getLastName(),
                        repoTeacher.getEmail(),
                        repoTeacher.getSalary(),
                        repoTeacher.getTimeStamp()
                )));
        return teachers;
    }
    @Override
    public Teacher createTeacher(TeacherDto teacherDto) {
        Teacher t = new Teacher();
        t.setFirstName(teacherDto.getFirstName());
        t.setLastName(teacherDto.getLastName());
        t.setSalary(teacherDto.getSalary());
        t.setEmail(teacherDto.getEmail());
        t.setTimeStamp(LocalDateTime.now());
        return this.repos.save(t);
    }

    @Override
    public Teacher getTeacher(Long id){
        return repos.findById(id).get();
    }
}
