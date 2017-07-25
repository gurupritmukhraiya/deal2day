package com.d2d.service.common.beans;

import java.io.Serializable;
import java.util.Date;

public class Filter implements Serializable {
	
    private static final long serialVersionUID = 3555814377560084655L;
    
    private int minDiscount;
    private int maxDiscount;
    private int minPrice;
    private int maxPrice;
    private int minCouponPrice;
    private int maxCouponPrice;
    private Date endDate;
    private Date startDate;
    private String city;
    private String[] area;
    private Long[] merchantIds;
    private Long merchantId;
    private Integer[] category;
    private String status;
    private int limit;
    private boolean isDistintMerchant;
    private String promoCode;
    private String summary;
    private String categoryName;
    private String merchantName;
    
    public boolean isDistintMerchant() {
		return isDistintMerchant;
	}
	public void setDistintMerchant(boolean isDistintMerchant) {
		this.isDistintMerchant = isDistintMerchant;
	}
	
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMinDiscount() {
        return this.minDiscount;
    }

    public void setMinDiscount(int minDiscount) {
        this.minDiscount = minDiscount;
    }

    public int getMaxDiscount() {
        return this.maxDiscount;
    }

    public void setMaxDiscount(int maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public int getMinPrice() {
        return this.minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return this.maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinCouponPrice() {
        return this.minCouponPrice;
    }

    public void setMinCouponPrice(int minCouponPrice) {
        this.minCouponPrice = minCouponPrice;
    }

    public int getMaxCouponPrice() {
        return this.maxCouponPrice;
    }

    public void setMaxCouponPrice(int maxCouponPrice) {
        this.maxCouponPrice = maxCouponPrice;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String[] getArea() {
        return this.area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }

    public Integer[] getCategory() {
        return this.category;
    }

    public void setCategory(Integer[] category) {
        this.category = category;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public Long[] getMerchantIds() {
		return merchantIds;
	}
	public void setMerchantIds(Long[] merchantIds) {
		this.merchantIds = merchantIds;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
		
}

