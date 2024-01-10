package com.example.demo.student.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "School_list",uniqueConstraints = {
        @UniqueConstraint(name = "Name", columnNames = "name")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SchoolStudents")
    @SequenceGenerator(name = "SchoolStudents",allocationSize = 50, sequenceName = "SchoolStudentsName")
    private long id;
    @Column(name = "name")
    private String name;
    private String email;
    private LocalDate dob;
    @Transient     //no creation of row
    private Integer age;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }



    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public Student(long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}