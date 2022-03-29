package com.example.school.service;

import com.example.school.dto.TeacherDto;
import com.example.school.model.Teacher;

import java.util.List;

public interface TeacherService {
    public List<TeacherDto> getTeachers();

    public Teacher createTeacher(TeacherDto teacherDto);

    public Teacher getTeacher(Long id);
}
