package com.thinkconstructive.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thinkconstructive.Model.CloudVendor;

import java.util.List;

@Repository
public class CloudVendorVulnerableDao {

    @Autowired
    private JdbcTemplate jdbc;  // ensure you have spring-boot‑starter‑jdbc on your classpath

    /**
     * ⚠ Intentionally insecure: concatenates raw user input, enabling SQL injection.
     */
    public List<CloudVendor> fetchByVendorName(String nameFilter) {
        String sql = "SELECT vendor_id, vendor_name, vendor_address, vendor_phone_number "
                   + "FROM cloud_vendor WHERE vendor_name = '" + nameFilter + "'";
        System.out.println("[DEBUG] Executing SQL: " + sql);

        return jdbc.query(
            sql,
            (rs, rowNum) -> new CloudVendor(
                rs.getString("vendor_id"),
                rs.getString("vendor_name"),
                rs.getString("vendor_address"),
                rs.getString("vendor_phone_number")
            )
        );
    }
}
