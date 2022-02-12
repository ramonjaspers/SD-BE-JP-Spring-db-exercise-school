package com.example.school.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    Long id;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 128, message = "First name has an invalid length")
    String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 128, message = "Last name has an invalid length")
    String lastName;

    @Email(message = "Invalid email")
    String email;

    @Max(value = 2000, message = "Costs are too high!")
    @Min(value = 1, message = "Costs are too low!")
    int costs;

    // LocalDate voor DATE only
    // Date = DATETIME in spring/DB
    @Past(message = "Date must be in the past!")
    @JsonFormat(pattern="dd-MM-yyyy")
    Date dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
