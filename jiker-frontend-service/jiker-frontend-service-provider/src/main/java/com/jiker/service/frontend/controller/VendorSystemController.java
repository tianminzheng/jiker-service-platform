package com.jiker.service.frontend.controller;

import com.jiker.service.middle.domain.VendorSystem;
import com.jiker.service.middle.service.ProductService;
import com.jiker.service.middle.service.VendorSystemService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "vendors")
public class VendorSystemController {

    @DubboReference(version = "${middle.service.version}")
    private VendorSystemService vendorSystemService;

    @PostMapping(value = "")
    public Long addVendorSystem(@RequestBody VendorSystem vendorSystem) {

        return vendorSystemService.addVendorSystem(vendorSystem);
    }

    @GetMapping(value = "/id/{venderSystemId}")
    public VendorSystem getVendorSystemById(@PathVariable Long venderSystemId){

        return vendorSystemService.getVendorSystemById(venderSystemId);
    }

    @GetMapping(value = "/code/{vendorCode}")
    public VendorSystem getVendorSystemByVendorCode(@PathVariable String vendorCode){

        return vendorSystemService.getVendorSystemByVendorCode(vendorCode);
    }

}
