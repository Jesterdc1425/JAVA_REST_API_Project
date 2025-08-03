package com.thinkconstructive.rest_demo.controller;

import com.thinkconstructive.Model.CloudVendor;
import com.thinkconstructive.Repository.CloudVendorRepository;
import com.thinkconstructive.Repository.CloudVendorVulnerableDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud vendor created successfully";
    }

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId) {
        return cloudVendorRepository.findById(vendorId).orElse(null);
    }


   @PutMapping
public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    cloudVendorRepository.save(cloudVendor);  // performs update if ID exists
    return "Cloud vendor updated successfully";
}


    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Cloud vendor deleted successfully";
    }



   // / ========== Vulnerable endpoint (for lab/test purposes only) ==========
    /**
     * ⚠️ Intentionally unsafe – merges user input directly into SQL.
     * Simulates SQL injection by concatenating the `vendor_name` parameter.
     */
    @Autowired
    private CloudVendorVulnerableDao vulnerableDao;

    @GetMapping("/vulnerable")
    public List<CloudVendor> fetchVulnerable(
        @RequestParam("vendor_name") String vendorName) {
    return vulnerableDao.fetchByVendorName(vendorName);
}

}