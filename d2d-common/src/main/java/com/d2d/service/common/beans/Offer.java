package com.d2d.service.common.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Offer implements Serializable {
	
    private static final long serialVersionUID = 7662806825932615322L;
    private long idx;
    private long merchantId;
    private String merchantName;
    private List<Long> locations;
    private List<Integer> categories;
    
    private String offerSummary;
    private String status;
    private int discount;
    private int couponPrice;
    private int minBillAmt;
    private String coverImage;
    private int rating;
    private Date startDate;
    private Date endDate;
    private Date createdDate;
    private List<String> description;
    private List<String> termsAndConditions;
    /*
     * added new variables
     */
    private String offerType;
    private List<String> howItWorks;
    private String contactNo;
    private String promoCode;
    private String url;
    private List<String> validDays;
    private List<String> menuURLs;
    private String imageURL;
    
    public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}

	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public List<Long> getLocations() {
		return locations;
	}
	public void setLocations(List<Long> locations) {
		this.locations = locations;
	}

	public List<Integer> getCategories() {
		return categories;
	}
	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}

	public int getMinBillAmt() {
		return minBillAmt;
	}
	public void setMinBillAmt(int minBillAmt) {
		this.minBillAmt = minBillAmt;
	}

	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<String> getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(List<String> termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	
	public String getOfferSummary() {
		return offerSummary;
	}
	public void setOfferSummary(String offerSummary) {
		this.offerSummary = offerSummary;
	}
	
	public List<String> getDescription() {
		return description;
	}
	public void setDescription(List<String> description) {
		this.description = description;
	}
	
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	
	public List<String> getHowItWorks() {
		return howItWorks;
	}
	public void setHowItWorks(List<String> howItWorks) {
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
	public List<String> getValidDays() {
		return validDays;
	}
	public void setValidDays(List<String> validDays) {
		this.validDays = validDays;
	}
	
	public List<String> getMenuURLs() {
		return menuURLs;
	}
	public void setMenuURLs(List<String> menuURLs) {
		this.menuURLs = menuURLs;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public boolean equals(Object obj) {
        if (obj != null && obj instanceof Offer) {
            Offer offer = (Offer)obj;
            if (this.idx == offer.idx) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (int) (3 * (idx + 1));
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
    
}

