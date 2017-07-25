package com.d2d.model.beans;

import com.d2d.model.beans.LocationModel;
import com.d2d.model.beans.MerchantProfile;
import com.d2d.model.beans.OfferModel;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="_mer_login", uniqueConstraints={@UniqueConstraint(columnNames={"_MER_ID"})})
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class MerchantLogin
implements Serializable {
    private static final long serialVersionUID = 4762596228274319136L;
    private Long idx;
    private String merchantId;
    private String password;
    private String role;
    private String status;
    private MerchantProfile merchantProfile;
    private Set<LocationModel> location;
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

    @Column(name="_MER_ID", nullable=false, updatable=false)
    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Column(name="_CRED", nullable=false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="_ROLE", nullable=false, updatable=false)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name="_STATUS", nullable=false)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="_IDX", unique=true, nullable=false)
    public MerchantProfile getMerchantProfile() {
        return this.merchantProfile;
    }

    public void setMerchantProfile(MerchantProfile merchantProfile) {
        this.merchantProfile = merchantProfile;
    }

    @OneToMany(mappedBy="merchant")
    public Set<LocationModel> getLocation() {
        return this.location;
    }

    public void setLocation(Set<LocationModel> location) {
        this.location = location;
    }

    @OneToMany(mappedBy="merchant")
    public Set<OfferModel> getOffers() {
        return this.offers;
    }

    public void setOffers(Set<OfferModel> offers) {
        this.offers = offers;
    }
}

