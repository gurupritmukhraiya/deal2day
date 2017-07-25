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
@Table(name="_subscriber")
public class SubscriberModel implements Serializable {

	private static final long serialVersionUID = -8268468351630011570L;
	
	private long idx;
	private String contactNo;
	private String email;
	private String status;
	private Date createDate;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="SUBSCBR_ID", unique=true, nullable=false)
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	
	 @Column(name="CONTACT_NUMBER", nullable=false)
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Column(name="EMAIL", nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	 @Column(name="STATUS", nullable=false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="CREATE_DATE_TIME", nullable=false)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
