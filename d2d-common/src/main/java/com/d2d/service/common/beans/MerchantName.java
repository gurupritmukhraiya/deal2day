package com.d2d.service.common.beans;

import java.io.Serializable;

public class MerchantName implements Serializable{

	private static final long serialVersionUID = 3213353753151125527L;
	
	 private long idx;
	 private long merchantId;
	 private String merchantName;
	
	
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof MerchantName){
			MerchantName merchantNameObj = (MerchantName)obj;
			return (idx == merchantNameObj.idx || merchantName.equals(merchantNameObj.merchantName));
		}
		return false;
	} 
}
