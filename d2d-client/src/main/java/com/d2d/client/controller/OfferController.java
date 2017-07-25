package com.d2d.client.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.d2d.cache.CategoryCache;
import com.d2d.cache.OfferCache;
import com.d2d.client.helper.ControllerUtil;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Location;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.intf.LocationServiceIntf;
import com.d2d.service.intf.OfferServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.JSONUtil;

public class OfferController extends MultiActionController{
	
	private OfferServiceIntf offerService = ServiceLocator.getServiceLocator().getOfferService();
	private LocationServiceIntf locationService = ServiceLocator.getServiceLocator().getLocationService();
		
	public ModelAndView viewOfferPage(HttpServletRequest request, HttpServletResponse responce){
		long mechantId = Long.parseLong(request.getParameter("p_d"));
		long offerId = Long.parseLong(request.getParameter("o_d"));
		
		Offer offer = offerService.getOffer(mechantId, offerId);
		if(offer != null){
			List<Location> locations = new LinkedList<Location>();
	 		List<Long> locationIds = offer.getLocations();
	 		if(locationIds != null){
				for (Long locationId : locationIds) {
					locations.add(locationService.getLocation(locationId));
				}
	 		}
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("offer", offer);
			model.put("locations", locations);
			
			return new ModelAndView("../d2d/view-offer-page.jsp", "model", model);
		}
		return new ModelAndView("../offer/Home.htm");
	}
	
	public void viewOffer(HttpServletRequest request, HttpServletResponse responce){
		long mechantId = Long.parseLong(request.getParameter("p_d"));
		long offerId = Long.parseLong(request.getParameter("o_d"));
		
		Offer offer = offerService.getOffer(mechantId, offerId);
		if(offer != null){
			String offerJSON = JSONUtil.getInstanse().getStringByObject(offer);
			try {
				responce.getWriter().write(offerJSON);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ControllerUtil controllerUtil = new ControllerUtil();
		controllerUtil.addAttribute("status", "fail");
		
		try {
			responce.getWriter().write(controllerUtil.getJSON());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView getFilteredOffer(HttpServletRequest request, HttpServletResponse responce, Filter filter){
		filter.setStartDate(new Date());
		filter.setEndDate(new Date());
		filter.setStatus("A");
		Set<Offer> offers = offerService.getOffersByFilter(filter, false);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("offers", offers);
		
		return new ModelAndView("../d2d/all-offers.jsp", "model", model);	 
	}
	
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse responce){
		Map<String, Object> model = new HashMap<String, Object>();
		List<Category> couponTypes = CategoryCache.getInstanse().getCategoryByType("COUPON TYPE");
		
		for (Category category : couponTypes) {
			List<Offer> offersFromCache = OfferCache.getInstanse().getOffersByType(category.getName());
			model.put(category.getName() + "<#id#>" + category.getIdx(), offersFromCache);
		}		
		return new ModelAndView("../d2d/Home.jsp", "model", model);	 				 
	}
	
	public ModelAndView getOfferForCloud(HttpServletRequest request, HttpServletResponse responce, Filter filter){
		
		String cloudName = request.getParameter("cname");
		
		filter.setStatus("A");
		filter.setCity(cloudName);
		filter.setArea(new String[]{cloudName});
		filter.setSummary(cloudName);
		filter.setMerchantName(cloudName);
		filter.setCategoryName(cloudName);
		
		Set<Offer> offers = offerService.getOffersByFilter(filter,true);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("CLOUD", offers);
		
		return new ModelAndView("../d2d/all-offers.jsp", "model", model);
		
	}
}
