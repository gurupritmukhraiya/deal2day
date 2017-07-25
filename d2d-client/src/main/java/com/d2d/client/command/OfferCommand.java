package com.d2d.client.command;

import java.io.Serializable;
import java.util.Date;

public class OfferCommand implements Serializable{

	private static final long serialVersionUID = -1511312886604867703L;
	
	private String idx;
	private String merchantId;
	private String merchantName;
	private String minBillAmt;
	private String discount;
	private String couponPrice;
	private String startDate;
	private String endDate;
	private Date createdDate;
	private String status;
	private String offerSummary;
	private String description;
	private String termsAndConditions;
	private String coverImage;
	private String[] categories;
	private String[] locations;
	/*
	 * added new variables
	 */
	private String offerType;
	private String[] howItWorks;
	private String contactNo;
	private String promoCode;
	private String url;
	private String menuPath;
	private String[] validDays;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	public String getMinBillAmt() {
		return minBillAmt;
	}
	public void setMinBillAmt(String minBillAmt) {
		this.minBillAmt = minBillAmt;
	}
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public String getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	public String[] getCategories() {
		return categories;
	}
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	
	public String[] getLocations() {
		return locations;
	}
	public void setLocations(String[] locations) {
		this.locations = locations;
	}
	
	
	public String getOfferSummary() {
		return offerSummary;
	}
	public void setOfferSummary(String offerSummary) {
		this.offerSummary = offerSummary;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	
	public String[] getHowItWorks() {
		return howItWorks;
	}
	public void setHowItWorks(String[] howItWorks) {
		this.howItWorks = howItWorks;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	
	public String[] getValidDays() {
		return validDays;
	}
	public void setValidDays(String[] validDays) {
		this.validDays = validDays;
	}	
}
