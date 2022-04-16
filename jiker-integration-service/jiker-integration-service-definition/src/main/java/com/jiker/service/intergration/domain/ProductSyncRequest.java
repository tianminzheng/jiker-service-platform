package com.jiker.service.intergration.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductSyncRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String requestNo;//唯一请求编号
    private Long vendorId;//供应商Id
    private String vendorCode;//供应商编号
    private String vendorSystemAddress;//供应商系统地址
    private Date startTime;//数据同步的起始时间
    private Date endTime;//数据同步的截止时间

    public ProductSyncRequest() {
    }

    public ProductSyncRequest(String requestNo, Long vendorId, String vendorCode, String vendorSystemAddress, Date startTime, Date endTime) {
        this.requestNo = requestNo;
        this.vendorId = vendorId;
        this.vendorCode = vendorCode;
        this.vendorSystemAddress = vendorSystemAddress;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorSystemAddress() {
        return vendorSystemAddress;
    }

    public void setVendorSystemAddress(String vendorSystemAddress) {
        this.vendorSystemAddress = vendorSystemAddress;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
