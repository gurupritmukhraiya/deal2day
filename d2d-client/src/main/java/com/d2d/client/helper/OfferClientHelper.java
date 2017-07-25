package com.d2d.client.helper;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.d2d.client.command.OfferCommand;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.util.DateUtil;

public class OfferClientHelper implements Serializable{

	private static final long serialVersionUID = -513349739962441695L;
	private static OfferClientHelper offerHelper;
	
	private OfferClientHelper(){
	
	}
	
	public static OfferClientHelper getInstance(){
		if(offerHelper == null){
			offerHelper = new OfferClientHelper();
		}
		return offerHelper;
	}
	
	public Offer getOfferByOfferCommand(OfferCommand offerCommand, boolean includeId){
        if (offerCommand != null) {
        	Offer offer = new Offer();
            try{
            	offer.setMerchantId(Long.parseLong(offerCommand.getMerchantId()));
            	offer.setMerchantName(offerCommand.getMerchantName());
            	
	            offer.setCouponPrice(Integer.parseInt(offerCommand.getCouponPrice()));
	            offer.setImageURL(offerCommand.getCoverImage());
	            offer.setCreatedDate(new Date());
	            offer.setDiscount(Integer.parseInt(offerCommand.getDiscount()));
	            offer.setEndDate(new Date(DateUtil.MM_DD_YYYY_TO_MILIS(offerCommand.getEndDate())));
	            offer.setMinBillAmt(Integer.parseInt(offerCommand.getMinBillAmt()));
	            offer.setOfferSummary(offerCommand.getOfferSummary());
	            offer.setStartDate(DateUtil.getDateFromAnyFormat(offerCommand.getStartDate()));
	            offer.setUrl(offerCommand.getUrl());
	            offer.setPromoCode(offerCommand.getPromoCode());
	            if(offerCommand.getStatus() != null)
	            	offer.setStatus(offerCommand.getStatus());
	            else
	            	offer.setStatus("Invalid");
	            
	            //Highlights	            
	            List<String> highlights = new LinkedList<String>();
	            String[] highlightsCommand = offerCommand.getDescription().split("\\.");
	            for (String highlightCommand : highlightsCommand) {
	            	if(highlightCommand.trim().isEmpty() == false)
	            		highlights.add(highlightCommand.trim());
				}
				offer.setDescription(highlights);
				
				//Terms & Condition
				List<String> terms = new LinkedList<String>();
	            String[] termsCommand = offerCommand.getTermsAndConditions().split("\\.");
	            for (String termCommand : termsCommand) {
	            	if(termCommand.trim().isEmpty() == false)
	            		terms.add(termCommand.trim());
				}
				offer.setTermsAndConditions(terms);
				
				//Categories	            
	            List<Integer> categories = new LinkedList<Integer>();
	            String[] categoriesCommand = offerCommand.getCategories();
	            for (String categoryCommand : categoriesCommand) {
	            	categories.add(Integer.parseInt(categoryCommand.trim()));
				}
	            offer.setCategories(categories );
	            
				//Locations
	            List<Long> locations = new LinkedList<Long>();
	            if(offerCommand.getLocations() != null){
		            String[] locationsCommand = offerCommand.getLocations();
		            for (String locationCommand : locationsCommand) {
		            	locations.add(Long.parseLong(locationCommand.trim()));
					}
		            offer.setLocations(locations);
	            }
	            if(includeId)
	            	offer.setIdx(Long.parseLong(offerCommand.getIdx()));
	            
	            return offer;
            }catch(Exception e){
            	e.printStackTrace();
            }           
        }
        return null;
	}
	
	public OfferCommand getOfferCommandFromRequest(MultipartHttpServletRequest request, boolean includeId){
		 OfferCommand command = new OfferCommand();
		 
		 command.setCouponPrice("-1");
		 command.setDiscount("-1");
		 command.setDescription("");
		 command.setLocations(null);
		 command.setMinBillAmt("-1");
		 command.setTermsAndConditions("");
		 command.setUrl("http://deal2day.in?merId=" + request.getSession().getAttribute("idx"));
		 command.setPromoCode("D2DIN");
		 command.setStartDate(DateUtil.MILIS_TO_dd_MMM_yyyy(new Date().getTime()));
		 
		 if(includeId)
		   command.setIdx(request.getParameter("idx"));
		 
		 String couponPrice = request.getParameter("couponPrice");
		 String discount = request.getParameter("discount");
		 String description = request.getParameter("description");
		 
		 String [] locations = request.getParameterValues("locations");
		 String minBillAmt = request.getParameter("minBillAmt");
		 String termsAndConditions = request.getParameter("termsAndConditions");
		 String URL = request.getParameter("url");
		 String promocode = request.getParameter("promoCode");
		 String startDate = request.getParameter("startDate");
		 
		 if(couponPrice != null && !couponPrice.isEmpty())
			 command.setCouponPrice(couponPrice);
		 if(discount != null && !discount.isEmpty())
			 command.setDiscount(discount);
		 if(description != null)
			 command.setDescription(description);
		 if(locations != null)
			 command.setLocations(locations);
		 if(minBillAmt != null && !minBillAmt.isEmpty())
			 command.setMinBillAmt(minBillAmt);
		 if(termsAndConditions != null)
			 command.setTermsAndConditions(termsAndConditions);
		 if(URL != null)
			 command.setUrl(URL);
		 if(promocode != null)
			 command.setPromoCode(promocode);
		 if(startDate != null)
			 command.setStartDate(startDate);
		 
		 command.setStatus(request.getParameter("status"));
		 command.setCategories(request.getParameterValues("categories"));
		 command.setEndDate(request.getParameter("endDate"));
		 command.setOfferSummary(request.getParameter("offerSummary"));
		 command.setCoverImage(request.getParameter("coverImage"));
		 return command;
	}
}
