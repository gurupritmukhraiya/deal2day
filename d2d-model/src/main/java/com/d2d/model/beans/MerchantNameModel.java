package com.d2d.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="_merchant_names")
public class MerchantNameModel implements Serializable{
	
	private static final long serialVersionUID = -345713883140112612L;
	private long idx;
	private String pname;
	private long merchantId;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="_IDX", unique=true, nullable=false)
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	
	 @Column(name="_MER_NAME", nullable=false)
	 public String getPname() {
			return pname;
	 }
	 public void setPname(String pname) {
			this.pname = pname;
	 }
	
	 @Column(name="_MER_ID", nullable=false)
	 public long getMerchantId() {
		return merchantId;
	 }
	 public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	 }
		 
}
