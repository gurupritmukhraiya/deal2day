package com.d2d.model.util;

import java.util.Date;

import com.d2d.model.beans.CouponHistoryModel;
import com.d2d.model.beans.SubscriberModel;
import com.d2d.service.common.beans.Coupon;
import com.d2d.service.common.beans.Subscriber;

public class CouponDBHelper {
	private static CouponDBHelper couponDBHelper;

    private CouponDBHelper() {
    }

    public static CouponDBHelper getInstance() {
        if (couponDBHelper == null) {
        	couponDBHelper = new CouponDBHelper();
        }
        return couponDBHelper;
    }
    
    public CouponHistoryModel getCouponModelByCoupon(Coupon coupon) {
    	CouponHistoryModel couponModel = null;
        if (coupon != null) {
        	couponModel = new CouponHistoryModel();
        	couponModel.setCouponCode(coupon.getCouponCode());
        	couponModel.setMobileNo(coupon.getMobileNo());
        	couponModel.setOfferId(coupon.getOfferId());
        	couponModel.setSentDateTime(new Date());
        }
        return couponModel;
    }
    
    public SubscriberModel getSubscriberModelBySubscriber(Subscriber subs){
    	SubscriberModel subsModel = null;
    	if(subs != null){
    		subsModel = new SubscriberModel();
    		if(subs.getContact().matches("\\d+")){
    			subsModel.setContactNo(subs.getContact());
    			subsModel.setEmail("NA");
    		}else{
    			subsModel.setContactNo("NA");
    			subsModel.setEmail(subs.getContact());
    		}
    		subsModel.setStatus("ACTIVE");
    		subsModel.setCreateDate(new Date());
    	}
    	return subsModel;
    }
}

