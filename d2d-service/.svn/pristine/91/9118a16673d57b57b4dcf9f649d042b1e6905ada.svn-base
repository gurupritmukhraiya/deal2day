package com.d2d.cache;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.d2d.db.mediator.intf.OfferDBMediatorIntf;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.locator.ServiceLocator;

public class OfferCache {
	
	private OfferDBMediatorIntf offerDBService = ServiceLocator.getServiceLocator().getOfferDBService();
    
    private static Map<String, List<Offer>> offerMap;
    private static Map<String, List<Offer>> offerByTypes;
    private static OfferCache offerServiceUtil;

    private OfferCache() {

    }
    
    public static void reloadCache(){
    	offerMap = null;
    	offerByTypes = null;
    	offerServiceUtil = null;
    	getInstanse();
    }

	public static OfferCache getInstanse() {
		if (offerMap == null) {
            offerMap = new ConcurrentHashMap<String, List<Offer>>();
        }
		if(offerByTypes == null){
			offerByTypes = new ConcurrentHashMap<String, List<Offer>>();
		}
        if (offerServiceUtil == null) {
            offerServiceUtil = new OfferCache();
            offerServiceUtil.getCachedOffers();
        }
        return offerServiceUtil;
    }

    private static String getTodaysDate_IN_yyyy_MM_dd() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String getYesterdayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.add(5, -1);
        return dateFormat.format(cal.getTime());
    }

    public List<Offer> getTodaysOffers() {
        return offerMap.get(getTodaysDate_IN_yyyy_MM_dd());
    }

    public void setTodaysOffers(List<Offer> offers) {
        offerMap.put(getTodaysDate_IN_yyyy_MM_dd(), offers);
    }

    public void removeYesterdaysOffers() {
        offerMap.remove(getYesterdayDate());
    }

    public void removeOffer(long offerId) {
        Offer offer = new Offer();
        offer.setIdx(offerId);
        this.getTodaysOffers().remove((Object)offer);
    }

    public void addOffer(Offer offer) {
        this.getTodaysOffers().add(offer);
    }
    
    public List<Offer> getCachedOffers(){
    	List<Offer> todaysOffers = getTodaysOffers();
        if (todaysOffers == null || todaysOffers.isEmpty()) {
        	OfferCache.getInstanse().removeYesterdaysOffers();
        	todaysOffers = new ArrayList<Offer>();
        	
        	Filter filter = new Filter();
            filter.setStartDate(new Date(System.currentTimeMillis()));
            filter.setEndDate(new Date(System.currentTimeMillis()));
            filter.setStatus("A");
            filter.setLimit(8);
            //filter.setDistintMerchant(true);
            
            List<Category> categories = CategoryCache.getInstanse().getCategoryByType("COUPON TYPE");
            
            Set<Offer> offersFromDB = new HashSet<Offer>(); 
			for (Category category : categories) {
            	Integer[] categoryId = {category.getIdx()};
            	filter.setCategory(categoryId);
            	offersFromDB = offerDBService.getOffersByFilter(filter, false);
            	for (Offer offerDB : offersFromDB) {
            		todaysOffers.add(offerDB);
            		addOfferWithType(category.getName(), offerDB);
				}
			}
            OfferCache.getInstanse().setTodaysOffers(todaysOffers);
        }
        return todaysOffers;    
    }
    
    public List<Offer> getOffersByType(String couponType) {
		return offerByTypes.get(couponType);
	}
    
    public void addOfferWithType(String type, Offer offer) {
    	List<Offer> offers = getOffersByType(type);
    	if(offers == null){
    		offers = new LinkedList<Offer>();
    	}
    	offers.add(offer);
    	offerByTypes.put(type, offers);
    }
}

