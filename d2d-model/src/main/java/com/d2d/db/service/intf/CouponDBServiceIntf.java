package com.d2d.db.service.intf;

import com.d2d.db.exception.DBServiceException;
import com.d2d.model.beans.CouponHistoryModel;
import com.d2d.model.beans.SubscriberModel;

public interface CouponDBServiceIntf {
	
	public void createCouponHistory(CouponHistoryModel couponHistoryModel)throws DBServiceException;
	public SubscriberModel getSubscriberInfo(String contact)throws DBServiceException;
	public void createSubscriber(SubscriberModel subsModel)throws DBServiceException;
	public int unSubscribeNewsletter(String contact)throws DBServiceException;
	
}

