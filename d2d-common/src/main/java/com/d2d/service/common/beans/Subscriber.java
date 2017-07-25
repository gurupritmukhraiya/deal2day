package com.d2d.service.common.beans;

import java.io.Serializable;
import java.util.Date;

public class Subscriber implements Serializable{
	
	private static final long serialVersionUID = 3063278846750486272L;
	
	private long idx;
	private String contact;
	private String status;
	private Date createDate;
	
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
