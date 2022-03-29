package com.example.school.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class TeacherDto {
    private final Long id;

    @NotBlank
    @Size(min = 2, max = 128)
    private final String firstName;

    @NotBlank
    @Size(min = 2, max = 128)
    private final String lastName;

    @Email
    private final String email;

    @Max(value = 10000, message = "THERE IS AN ATTEMPT OF FRAUD")
    private final int salary;

    @DateTimeFormat
    private final LocalDateTime timeStamp;
}
