package com.thinkconstructive.Repository;

import com.thinkconstructive.Model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    // No need to explicitly declare 'update'
}
