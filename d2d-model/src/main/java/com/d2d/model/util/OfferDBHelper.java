package com.d2d.model.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.d2d.model.beans.CategoryModel;
import com.d2d.model.beans.LocationModel;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.OfferModel;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Location;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.Offer;

public class OfferDBHelper {
    private static OfferDBHelper offerDBHelper;

    private OfferDBHelper() {
    }

    public static OfferDBHelper getInstance() {
        if (offerDBHelper == null) {
            offerDBHelper = new OfferDBHelper();
        }
        return offerDBHelper;
    }

    public Offer getOfferByOfferModel(OfferModel offerModel, boolean includeMerchant, boolean includeLocation) {
        Offer offer = null;
        if (offerModel != null) {
            offer = new Offer();
            offer.setCouponPrice(offerModel.getCouponPrice());
            offer.setCreatedDate(offer.getCreatedDate());
            offer.setEndDate(offerModel.getEndDate());
            offer.setIdx(offerModel.getIdx());
            offer.setUrl(offerModel.getURL());
            offer.setPromoCode(offerModel.getPromoCode());
            offer.setRating(offerModel.getRating());
            offer.setStartDate(offerModel.getStartDate());
            offer.setStatus(offerModel.getStatus());
            if (includeLocation) {
                LinkedList<Long> loactions = new LinkedList<Long>();
                Set<LocationModel> locationModels = offerModel.getLocations();
                for (LocationModel locationModel : locationModels) {
                    Location location = LocationDBHelper.getInstance().getLocationByLocationModel(locationModel);
                    loactions.add(location.getIdx());
                }
                offer.setLocations(loactions);
            }
            if (includeMerchant) {
                Merchant merchant = MerchantDBHelper.getInstance().getMerchantByMerchantLogin(offerModel.getMerchant(), false, false);
                offer.setMerchantId(merchant.getIdx());
                offer.setMerchantName(merchant.getMerchantName());
            }
            offer.setImageURL(offerModel.getImageURL());
            offer.setOfferSummary(offerModel.getTitle());
        }
        return offer;
    }

    public OfferModel getOfferModelByOffer(Offer offer, boolean includeMerchant, boolean includeLocation,boolean includeCategory, boolean includeIdx) {
        OfferModel offerModel = null;
        if (offer != null) {
            offerModel = new OfferModel();
           
            if(offer.getCouponPrice() == 0)
            	offer.setCouponPrice(0);
            offerModel.setCouponPrice(offer.getCouponPrice());
            
            offerModel.setCreatedDate(offer.getCreatedDate());
            
            offerModel.setEndDate(offer.getEndDate());
            
            offerModel.setURL(offer.getUrl());
            offerModel.setPromoCode(offer.getPromoCode());
            
            if(offer.getRating() == 0)
            	offer.setRating(0);
            offerModel.setRating(offer.getRating());
            
            offerModel.setStartDate(offer.getStartDate());
            offerModel.setTitle(offer.getOfferSummary());
            offerModel.setImageURL(offer.getImageURL());
            offerModel.setStatus(offer.getStatus());
            if (includeLocation) {
                HashSet<LocationModel> locationModels = new HashSet<LocationModel>();
                List<Long> offerLoc = offer.getLocations();
                if(offerLoc != null && offerLoc.isEmpty() == false){
	                List<Long> locations = offer.getLocations();
	                for (Long locationId : locations) {
	                    LocationModel locationModel = new LocationModel();
	                    locationModel.setIdx(locationId);
	                    locationModels.add(locationModel);
	                }
                }
                offerModel.setLocations(locationModels);
            }
            if (includeMerchant) {
                Long merchantId = offer.getMerchantId();
                MerchantLogin merchantLogin = new MerchantLogin();
                merchantLogin.setIdx(merchantId);
                offerModel.setMerchant(merchantLogin);
            }
            if (includeCategory) {
            	Set<CategoryModel> categoryModels = new HashSet<CategoryModel>();
                List<Integer> categories = offer.getCategories();
                for (Integer categoryId : categories) {
					CategoryModel categoryModel = new CategoryModel();
					categoryModel.setIdx(categoryId);
					categoryModels.add(categoryModel);
				}
                
				offerModel.setCategory(categoryModels);
            }
            if(includeIdx){
            	offerModel.setIdx(offer.getIdx());
            }
        }
        return offerModel;
    }
    
    
    public CategoryModel getCategoryModelByCategory(Category category, boolean isCatIdx){
    	CategoryModel categoryModel = null;
    	if(category != null){
    		categoryModel = new CategoryModel();
    		categoryModel.setName(category.getName());
    		categoryModel.setParent(category.getParent());
    		categoryModel.setType(category.getType());
    	if(isCatIdx)
    		categoryModel.setIdx(category.getIdx());
    	}
    	return categoryModel;
    }
    
    public Category getCategoryByCategoryModel(CategoryModel categoryModel){
    	Category category = null;
    	if(categoryModel != null){
    		category = new Category();
    		category.setIdx(categoryModel.getIdx());
    		category.setName(categoryModel.getName());
    		category.setParent(categoryModel.getParent());
    		category.setType(categoryModel.getType());
    	}
    	return category;
    }
}

