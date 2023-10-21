package com.thinkconstructive.restdemo.service;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(Integer cloudVendorId);
    public CloudVendor getCloudVendor(Integer cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
    public List<CloudVendor> getByVendorName(String vendorName);
}