package com.jiker.service.middle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiker.service.middle.domain.VendorSystem;

@Repository
public interface VendorSystemRepository extends JpaRepository<VendorSystem, Long> {

    VendorSystem getVendorSystemByVendorCode(String vendorCode);
}
