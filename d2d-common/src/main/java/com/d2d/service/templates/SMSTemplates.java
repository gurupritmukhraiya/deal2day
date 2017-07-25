package com.d2d.service.templates;

import com.d2d.service.common.beans.Coupon;


public class SMSTemplates {
    public static String sendCouponCodeTamplate(Coupon coupon) {
        return "deal2day.in : Your coupon code is " + coupon.getCouponCode()
        		+ " for " + coupon.getProviderName() + ", " + coupon.getLocation() 
        		+ " has to be redeemed before " + coupon.getEndDate() + ". Query? Call-9867598284";
    }
    
    public static String sendInfoToMerchantTemplate(Coupon coupon, String offerSummary){
    	return "deal2day.in : Your offfer ("+ offerSummary.substring(0, (offerSummary.length()/2)) +") is downloaded By " + coupon.getUserName()
        		+ " He will redeem soon. Query? Call-9867598284";
    }
}

