package com.jiker.service.middle.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "vendor_system")
public class VendorSystem implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//供应商系统Id
    private String vendorCode;//供应商系统编号
    private String vendorName;//供应商系统名称
    private String description;//供应商系统描述
    private String ip;//供应商系统IP
    private String port;//供应商系统端口

    public VendorSystem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
