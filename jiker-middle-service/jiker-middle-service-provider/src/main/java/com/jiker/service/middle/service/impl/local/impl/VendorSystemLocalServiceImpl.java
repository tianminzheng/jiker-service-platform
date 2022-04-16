package com.jiker.service.middle.service.impl.local.impl;

import com.jiker.service.infrastructure.exception.ServiceException;
import com.jiker.service.middle.domain.VendorSystem;
import com.jiker.service.middle.repository.VendorSystemRepository;
import com.jiker.service.middle.service.impl.local.VendorSystemLocalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorSystemLocalServiceImpl implements VendorSystemLocalService {

    @Autowired
    private VendorSystemRepository vendorSystemRepository;

    @Override
    public List<VendorSystem> getAllVendorSystems() {
        return vendorSystemRepository.findAll();
    }

    @Override
    public VendorSystem getVendorSystemById(Long id) {
        return vendorSystemRepository.findById(id).orElse(new VendorSystem());
    }

    @Override
    public VendorSystem getVendorSystemByVendorCode(String vendorCode) {
        return vendorSystemRepository.getVendorSystemByVendorCode(vendorCode);
    }

    @Override
    public Long addVendorSystem(VendorSystem vendorSystem) {
        checkVendorSystemIsExisted(vendorSystem);

        vendorSystemRepository.save(vendorSystem);
        return vendorSystem.getId();
    }

    @Override
    public void updateVendorSystem(VendorSystem vendorSystem) {
        checkVendorSystemIsExisted(vendorSystem);

        vendorSystemRepository.save(vendorSystem);
    }

    private void checkVendorSystemIsExisted(VendorSystem vendorSystem) {
        VendorSystem existed = vendorSystemRepository.getVendorSystemByVendorCode(vendorSystem.getVendorCode());
        if(existed != null)
            throw new ServiceException("The vendor system: " + vendorSystem.getVendorCode() + " is already existed!");
    }
}
