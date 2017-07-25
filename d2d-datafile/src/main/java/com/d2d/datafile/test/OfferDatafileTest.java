package com.d2d.datafile.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.d2d.datafile.mediator.impl.OfferDatafileMediatorImpl;
import com.d2d.service.common.beans.Offer;

public class OfferDatafileTest {
	
	OfferDatafileMediatorImpl datafileMediatorImpl = new OfferDatafileMediatorImpl();
	
    public static void main(String[] args) {
       new OfferDatafileTest().createOffer();
       System.out.println("Done");
    }
    
    
    public void createOffer() {
        Offer offer = new Offer();
        offer.setCouponPrice(10);
        offer.setDiscount(50);
        offer.setMinBillAmt(100);
        offer.setCreatedDate(new Date());
        offer.setEndDate(new Date());
        offer.setStartDate(new Date());
        offer.setStatus("A");
        offer.setRating(5);
        offer.setCoverImage("../img/test.png");
        
        List<String> highlights = new LinkedList<String>();
        highlights.add("this is very good offer");
        highlights.add("Use this offer");
        highlights.add("10% Discount");
		offer.setDescription(highlights);
		
		List<String> terms = new LinkedList<String>();
		terms.add("Terms");
		terms.add("my offer terms");
		offer.setTermsAndConditions(terms);
		
		offer.setIdx(1);
		offer.setOfferSummary("this is offer summary");
		
        offer.setMerchantId(1);
        
        List<Long> locations = new LinkedList<Long>();
		locations.add(1L);
        offer.setLocations(locations);
        
        List<Integer> categories = new LinkedList<Integer>();
        categories.add(1);
        offer.setCategories(categories);
        
        datafileMediatorImpl.createOffer(offer);
    }
}

