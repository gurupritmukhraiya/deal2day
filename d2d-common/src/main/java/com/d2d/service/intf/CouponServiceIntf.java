package com.d2d.service.intf;

import com.d2d.service.common.beans.Coupon;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.common.beans.Subscriber;
import com.d2d.service.util.Response;


public interface CouponServiceIntf {
   
	public void sendCoupon(Coupon coupon);
	public Response registerSubscriber(Subscriber subs);
	public Response unSubscribeNewsLetter(String contact);
	public Response sendDeal(Coupon coupon,boolean isContact,boolean isEmail);
	public void informToMerchantByMail(Coupon coupon, Offer offer, Merchant merchant);
	public void informToMerchantBySMS(Coupon coupon, String offerSummary,String mobileNo);
}

