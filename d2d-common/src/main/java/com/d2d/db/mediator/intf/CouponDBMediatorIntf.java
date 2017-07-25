package com.d2d.db.mediator.intf;

import com.d2d.service.common.beans.Coupon;
import com.d2d.service.common.beans.Subscriber;

public interface CouponDBMediatorIntf {
    
	public void addSentCoupon(Coupon coupon);
	public Subscriber addSubscriber(Subscriber subs);
	public boolean isSubscriberExist(String contact);
	public boolean unSubscribe(String contact);

}

