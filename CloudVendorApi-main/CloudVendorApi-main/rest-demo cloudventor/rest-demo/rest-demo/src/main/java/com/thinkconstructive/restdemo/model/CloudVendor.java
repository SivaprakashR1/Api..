package com.thinkconstructive.restdemo.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
@CrossOrigin(origins = "http://localhost:4200/")
@Entity
@Table(name="Student_details")
public class CloudVendor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendorId;
    private String vendorName;
    private String vendorRollNumber;
    private String vendorEmail;
    private String vendorDepartment;

    public CloudVendor(Integer vendorId, String vendorName, String vendorRollNumber, String vendorEmail, String vendorDepartment) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorRollNumber = vendorRollNumber;
        this.vendorEmail = vendorEmail;
        this.vendorDepartment = vendorDepartment;
    }


    public CloudVendor() {
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorRollNumber() {
        return vendorRollNumber;
    }

    public void setVendorRollNumber(String vendorRollNumber) {
        this.vendorRollNumber = vendorRollNumber;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorDepartment() {
        return vendorDepartment;
    }

    public void setVendorDepartment(String vendorDepartment) {
        this.vendorDepartment = vendorDepartment;
    }

}