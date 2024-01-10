package com.students.data.controller;

import com.students.data.model.StudentData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/student")

public class StudentAPIService
{
    @Autowired
    StudentData studentData;

    public StudentAPIService (){
        this.studentData = studentData;
    }
    @GetMapping
    public StudentData getStudentDataDetails(String name){
        return studentData;
    }
    @GetMapping("/{id}")
    public StudentData getStudentDataDetails(@PathVariable ("id") Integer id){
        return studentData;
    }
    @PostMapping
    @Transactional
    public String createStudentDetails(@RequestBody StudentData studentData){
        this.studentData = studentData;
        return "Cloud Vendor Created Successfully";
    }
    @PutMapping
    @Transactional
    public String updateStudentDetails(@RequestBody StudentData studentData) {
        this.studentData = studentData;
        return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping ("{id}")
    @Transactional

    public String DeleteStudentDetails(String vendorId){
        this.studentData = null;
        return "Cloud Vendor Deleted Successfully";
    }
}