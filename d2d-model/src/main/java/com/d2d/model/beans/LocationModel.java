package com.d2d.model.beans;

import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.OfferModel;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_location")
public class LocationModel implements Serializable {
	
    private static final long serialVersionUID = 8076317449588621567L;
    
    private Long idx;
    private String country;
    private String state;
    private String city;
    private String area;
    private String address;
    private String pincode;
    private String contactNo;
    private MerchantLogin merchant;
    private Set<OfferModel> offers;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="_IDX", unique=true, nullable=false)
    public Long getIdx() {
        return this.idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    @Column(name="_COUNTRY", nullable=false)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="_STATE", nullable=false)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="_CITY", nullable=false)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="_AREA", nullable=false)
    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name="_ADDRESS", nullable=false)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="_PIN_CODE", nullable=false)
    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Column(name="_CONTACT_NO", nullable=false)
    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="_MER_ID", nullable=false)
    public MerchantLogin getMerchant() {
        return this.merchant;
    }

    public void setMerchant(MerchantLogin merchant) {
        this.merchant = merchant;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="locations")
    public Set<OfferModel> getOffers() {
        return this.offers;
    }

    public void setOffers(Set<OfferModel> offers) {
        this.offers = offers;
    }
}

