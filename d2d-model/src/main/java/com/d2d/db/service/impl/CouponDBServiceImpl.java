package com.d2d.db.service.impl;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.service.intf.CouponDBServiceIntf;
import com.d2d.model.beans.CouponHistoryModel;
import com.d2d.model.beans.SubscriberModel;
import com.d2d.model.dao.intf.CouponDAOIntf;

public class CouponDBServiceImpl implements CouponDBServiceIntf{

	private CouponDAOIntf couponDAOIntf;
	
	public CouponDAOIntf getCouponDAOIntf() {
		return couponDAOIntf;
	}
	public void setCouponDAOIntf(CouponDAOIntf couponDAOIntf) {
		this.couponDAOIntf = couponDAOIntf;
	}

	@Override
	public void createCouponHistory(CouponHistoryModel couponHistoryModel) throws DBServiceException {
		getCouponDAOIntf().addCouponHistory(couponHistoryModel);		
	}
	
	@Override
	public SubscriberModel getSubscriberInfo(String contact) throws DBServiceException {
		return getCouponDAOIntf().getSubscriber(contact);
	}
	
	@Override
	public void createSubscriber(SubscriberModel subsModel)
			throws DBServiceException {
		try {
            this.getCouponDAOIntf().createSubscriber(subsModel);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
		
	}
	
	@Override
	public int unSubscribeNewsletter(String contact)
			throws DBServiceException {
		return getCouponDAOIntf().unSubscribeNewsletter(contact);
	}
	
	
}

