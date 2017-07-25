package com.d2d.service.common.beans;

import com.d2d.service.common.beans.Location;
import com.d2d.service.common.beans.Offer;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Merchant implements Serializable {
    
	private static final long serialVersionUID = -3556094082147470494L;
    private long idx;
    private String merchantName;
    private String contactNo;
    private String emailId;
    private String oldPassword;
    private String password;
    private String status;
    private String role;
    private Date createdDate;
    private List<Offer> offers;
    private List<Location> locations;
    
    /**
     * @return
     * Two fields Add for merchant registration by Admin
     */
    private String URL;
    private String imagePath;
    private String createdBy;

    public long getIdx() {
        return this.idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Offer> getOffers() {
        return this.offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}

