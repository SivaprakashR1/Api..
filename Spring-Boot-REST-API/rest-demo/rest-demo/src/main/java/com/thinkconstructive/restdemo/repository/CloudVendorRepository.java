package com.thinkconstructive.restdemo.repository;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
public interface CloudVendorRepository extends JpaRepository<CloudVendor, Integer> {
    List<CloudVendor> findByVendorName(String vendorName);
}