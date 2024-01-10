package com.students.data.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
@Entity
@Table(name = "child_list")

@Component
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer roll;
    private String email;
    private String department;

    public StudentData(Integer id, String name, Integer roll, String email, String department) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.email = email;
        this.department = department;
    }
    public StudentData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public StudentData(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



}
