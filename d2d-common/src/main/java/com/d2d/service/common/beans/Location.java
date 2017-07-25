package com.d2d.service.common.beans;

import java.io.Serializable;

public class Location implements Serializable {
	
    private static final long serialVersionUID = 5154531445909876820L;
    
    private long idx;
    private long merchantId;
    private String country;
    private String state;
    private String city;
    private String area;
    private String address;
    private String pincode;
    private String contactNo;

    public long getIdx() {
        return this.idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public long getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}

