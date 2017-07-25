package com.d2d.model.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="_mer_profile", uniqueConstraints={@UniqueConstraint(columnNames={"_EMAIL"}), @UniqueConstraint(columnNames={"_MER_NAME"})})
public class MerchantProfile
implements Serializable {
    private static final long serialVersionUID = 7782730743130602840L;
    private long idx;
    private String contactNo;
    private String email;
    private String merchantName;
    private Date createDate;
    
    /*@Author.
     * Add two fields for Merchant Registration by Admin
     * 
     */
    private String URL;
    private String ImagePath;
    private String addBy;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getIdx() {
        return this.idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    @Column(name="_CONTACT_NO", nullable=false)
    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Column(name="_EMAIL", nullable=false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="_MER_NAME", nullable=false, updatable=false)
    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Column(name="_CREATED_DATE", nullable=false)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name="_URL", nullable=false) 
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Column(name="_IMAGE_PATH", nullable=false)
	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	@Column(name="_ADD_BY")
	public String getCreatedBy() {
		return addBy;
	}

	public void setCreatedBy(String addBy) {
		this.addBy = addBy;
	}
}

