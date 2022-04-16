package com.jiker.service.middle.service;

import com.jiker.service.middle.domain.VendorSystem;

public interface VendorSystemService {

    VendorSystem getVendorSystemById(Long id);

    VendorSystem getVendorSystemByVendorCode(String vendorCode);

    Long addVendorSystem(VendorSystem vendorSystem);

    void updateVendorSystem(VendorSystem vendorSystem);
}
