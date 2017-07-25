package com.d2d.model.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="_coupon")
public class CouponHistoryModel implements Serializable {
	
    private static final long serialVersionUID = 8019295717945942033L;
    
    private long couponId;
    private long offerId;
    private String couponCode;
    private String mobileNo;
    private Date sentDateTime;    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="COUPON_ID", unique=true, nullable=false)
    public long getCouponId() {
        return this.couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    @Column(name="COUPON_CODE", nullable=false)
    public String getCouponCode() {
        return this.couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Column(name="MOBILE_NUMBER", nullable=false)
    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

	@Column(name="SENT_DATE_TIME", nullable=false)
    public Date getSentDateTime() {
		return sentDateTime;
	}
	public void setSentDateTime(Date sentDateTime) {
		this.sentDateTime = sentDateTime;
	}

	@Column(name="OFFER_ID", nullable=false)
    public long getOfferId() {
        return this.offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }
}

