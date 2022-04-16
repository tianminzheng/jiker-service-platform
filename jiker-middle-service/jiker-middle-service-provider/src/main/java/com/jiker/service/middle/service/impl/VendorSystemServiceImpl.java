package com.jiker.service.middle.service.impl;

import com.jiker.service.middle.domain.VendorSystem;
import com.jiker.service.middle.service.VendorSystemService;
import com.jiker.service.middle.service.impl.local.VendorSystemLocalService;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "${middle.service.version}")
public class VendorSystemServiceImpl implements VendorSystemService {

    @Autowired
    private VendorSystemLocalService vendorSystemLocalService;

    @Override
    public VendorSystem getVendorSystemById(Long id) {

        return vendorSystemLocalService.getVendorSystemById(id);
    }

    @Override
    public VendorSystem getVendorSystemByVendorCode(String vendorCode) {

        return vendorSystemLocalService.getVendorSystemByVendorCode(vendorCode);
    }

    @Override
    public Long addVendorSystem(VendorSystem vendorSystem) {

        return vendorSystemLocalService.addVendorSystem(vendorSystem);
    }

    @Override
    public void updateVendorSystem(VendorSystem vendorSystem) {

        vendorSystemLocalService.updateVendorSystem(vendorSystem);
    }
}
