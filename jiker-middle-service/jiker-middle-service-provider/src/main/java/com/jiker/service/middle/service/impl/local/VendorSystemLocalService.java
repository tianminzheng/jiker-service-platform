package com.jiker.service.middle.service.impl.local;

import java.util.List;

import com.jiker.service.middle.domain.VendorSystem;

public interface VendorSystemLocalService {

	//获取所有供应商系统
    List<VendorSystem> getAllVendorSystems();

	//根据Id获取供应商系统
    VendorSystem getVendorSystemById(Long id);

	//根据编号获取供应商系统
    VendorSystem getVendorSystemByVendorCode(String vendorCode);

	//添加供应商系统
    Long addVendorSystem(VendorSystem vendorSystem);

	//更新供应商系统
    void updateVendorSystem(VendorSystem vendorSystem);
}
