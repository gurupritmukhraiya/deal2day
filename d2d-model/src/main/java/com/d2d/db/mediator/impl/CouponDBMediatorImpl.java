package com.d2d.db.mediator.impl;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.mediator.intf.CouponDBMediatorIntf;
import com.d2d.db.service.intf.CouponDBServiceIntf;
import com.d2d.model.bean.factory.CouponBeanFactory;
import com.d2d.model.beans.CouponHistoryModel;
import com.d2d.model.beans.SubscriberModel;
import com.d2d.model.util.CouponDBHelper;
import com.d2d.service.common.beans.Coupon;
import com.d2d.service.common.beans.Subscriber;


public class CouponDBMediatorImpl implements CouponDBMediatorIntf{
	
	private CouponDBServiceIntf couponDBService = CouponBeanFactory.getCouponDBService();
	private CouponDBHelper couponHelper  = CouponDBHelper.getInstance();
	
	@Override
	public void addSentCoupon(Coupon coupon) {
		try {
            CouponHistoryModel couponHistoryModel = couponHelper.getCouponModelByCoupon(coupon);
            couponDBService.createCouponHistory(couponHistoryModel);
        } catch (DBServiceException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public Subscriber addSubscriber(Subscriber subs) {
		if(!this.isSubscriberExist(subs.getContact())){
			SubscriberModel subsModel = this.couponHelper.getSubscriberModelBySubscriber(subs);
			if(subsModel != null){
				try {
                    this.couponDBService.createSubscriber(subsModel);
                    subs.setIdx(subsModel.getIdx());
                }
                catch (DBServiceException e) {
                    e.printStackTrace();
                    return null;
                }
			}
		}else{
			return null;
		}
		return subs;
	}
	
	@Override
	public boolean isSubscriberExist(String contact) {
		try{
			if(this.couponDBService.getSubscriberInfo(contact) != null){
				return true;
			}
		}catch(DBServiceException e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean unSubscribe(String contact) {
		try{
		int temp = this.couponDBService.unSubscribeNewsletter(contact);
		if(temp != 0)
			return true;
		}catch(DBServiceException ex){
			ex.printStackTrace();
			return false;
		}
		return false;
	}

}

