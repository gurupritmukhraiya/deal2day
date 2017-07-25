package com.d2d.client.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.d2d.client.helper.ControllerUtil;
import com.d2d.service.common.beans.Coupon;
import com.d2d.service.common.beans.Subscriber;
import com.d2d.service.intf.CouponServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.Response;

public class CouponController extends MultiActionController{
	
	private CouponServiceIntf couponService = ServiceLocator.getServiceLocator().getCouponService();
		
	public void sendCoupon(HttpServletRequest request, HttpServletResponse responce, Coupon coupon){
		couponService.sendCoupon(coupon);	 				 
	}
	
	public void subscribe(HttpServletRequest request, HttpServletResponse response){
		String contact = request.getParameter("contact").toString();
		Subscriber subscriber = new Subscriber();
		subscriber.setContact(contact);
		Response result = couponService.registerSubscriber(subscriber);
		
		ControllerUtil controllerUtil = new ControllerUtil();
		try {
			controllerUtil.addAttribute("status", result.getStatus());
			controllerUtil.addAttribute("message", result.getMassage());
			response.getWriter().write(controllerUtil.getJSON());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void unsubscribe(HttpServletRequest request, HttpServletResponse responce){
		String contact = request.getParameter("contact").toString();
		
		couponService.unSubscribeNewsLetter(contact);	 				 
	}
	
	public void sendDeal(HttpServletRequest request, HttpServletResponse response, Coupon coupon){
		
		System.out.println(request.getParameter("o_source") +"=="+request.getParameter("p_source"));
		coupon.setSendTo(request.getParameter("u_target"));
		coupon.setOfferId(Long.parseLong(request.getParameter("o_source")));
		coupon.setProviderId(Long.parseLong(request.getParameter("p_source")));
		//coupon.setUserName(request.getParameter("c_target"));
		coupon.setUserName("-NA-");
		
		
		String send = coupon.getSendTo().trim();
		Response result = new Response("fail","some thing worng, Please try after some time");
		
		if(send.matches("\\d+") && send.length() == 10){
			coupon.setMobileNo(send);
			result = couponService.sendDeal(coupon,true,false);
		}
		else
			result = couponService.sendDeal(coupon,false, true);
		
		ControllerUtil controllerUtil = new ControllerUtil();
		try {
			controllerUtil.addAttribute("status", result.getStatus());
			controllerUtil.addAttribute("message", result.getMassage());
			response.getWriter().write(controllerUtil.getJSON());
		} catch (IOException e) {
			e.printStackTrace();
	  }	
    }

}
