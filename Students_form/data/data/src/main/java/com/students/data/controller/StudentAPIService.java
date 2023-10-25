package com.students.data.controller;

import com.students.data.model.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/student")
public class StudentAPIService
{
    @Autowired
    StudentData studentData;
    @GetMapping
    public StudentData getStudentDataDetails(String name){
        return studentData;
    }
    @PostMapping
    public String createCloudVendorDetails(@RequestBody StudentData studentData){
        this.studentData = studentData;
        return "Cloud Vendor Created Successfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody StudentData studentData) {
        this.studentData = studentData;
        return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping("{id}")
    public String DeleteCloudVendorDetails(String vendorId){
        this.studentData = null;
        return "Cloud Vendor Deleted Successfully";
    }
}