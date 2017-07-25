package com.d2d.model.dao.intf;

import com.d2d.db.exception.DBServiceException;
import com.d2d.model.beans.CouponHistoryModel;
import com.d2d.model.beans.SubscriberModel;

public interface CouponDAOIntf {
   
	public void addCouponHistory(CouponHistoryModel couponHistoryModel) throws DBServiceException;
	public SubscriberModel getSubscriber(String contact)  throws DBServiceException;
	public void createSubscriber(SubscriberModel subsModel) throws DBServiceException;
	public int unSubscribeNewsletter(String contact) throws DBServiceException;
	
}

