package com.d2d.model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_offer")
public class OfferModel implements Serializable {
    
	private static final long serialVersionUID = 7108025117679037833L;
    private Long idx;
    private Date startDate;
    private Date endDate;
    private String status;
    private Integer couponPrice;
    private Integer rating;
    private Date createdDate;
    private String title;
    private String imageURL;
    private String promoCode;
    private String URL;
    private MerchantLogin merchant;
    private Set<LocationModel> locations;
    private Set<CategoryModel> category;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="_IDX", unique=true, nullable=false)
    public Long getIdx() {
        return this.idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    @Column(name="_START_DATE", nullable=false)
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name="_END_DATE", nullable=false)
    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name="_STATUS", nullable=false)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="_COUPON_PRICE", nullable=false)
    public Integer getCouponPrice() {
        return this.couponPrice;
    }
    public void setCouponPrice(Integer couponPrice) {
        this.couponPrice = couponPrice;
    }

    @Column(name="_RATING", nullable=false)
    public Integer getRating() {
        return this.rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name="_CREATED_DATE", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="_MER_ID", nullable=false)
    public MerchantLogin getMerchant() {
        return this.merchant;
    }
    public void setMerchant(MerchantLogin merchant) {
        this.merchant = merchant;
    }

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="_offer_address", joinColumns={@JoinColumn(name="_OFFER_ID", nullable=true)}, inverseJoinColumns={@JoinColumn(name="_ADDRESS_ID", nullable=true)})
    public Set<LocationModel> getLocations() {
        return this.locations;
    }
    public void setLocations(Set<LocationModel> locations) {
        this.locations = locations;
    }

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="_offer_category", joinColumns={@JoinColumn(name="_OFFER_ID", nullable=false)}, inverseJoinColumns={@JoinColumn(name="_CATEGORY_ID", nullable=false)})
    public Set<CategoryModel> getCategory() {
		return category;
	}

	public void setCategory(Set<CategoryModel> category) {
		this.category = category;
	}

	@Column(name="_TITLE", nullable=false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="_IMAGE_URL", nullable=false)
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Column(name="_PROMO_CODE", nullable=false)
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	@Column(name="_URL", nullable=false)
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}	
}

