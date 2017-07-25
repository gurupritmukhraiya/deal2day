package com.d2d.service.common.beans;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable {
	
    private static final long serialVersionUID = 7415067916125892752L;
    
    private long couponId;
    private long offerId;
    private long providerId;
    private String userName;
    private String contactNo;
    private String sendTo;
    private String providerName;
    private String endDate;
    private String location;
    private String couponCode;
    private String mobileNo;  
    private Date sentDate;

    public long getCouponId() {
        return this.couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode.toUpperCase();
    }
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public long getOfferId() {
        return this.offerId;
    }
    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

	public String getProviderName() {
		return providerName.toUpperCase();
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location.toUpperCase();
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
    
	
	
}

