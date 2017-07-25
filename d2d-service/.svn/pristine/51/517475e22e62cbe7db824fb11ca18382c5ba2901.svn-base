package com.d2d.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.d2d.cache.CategoryCache;
import com.d2d.cache.OfferCache;
import com.d2d.constants.D2DConstant;
import com.d2d.constants.ImageConstant;
import com.d2d.datafile.mediator.intf.OfferDatafileMediatorIntf;
import com.d2d.db.mediator.intf.OfferDBMediatorIntf;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.intf.MerchantServiceIntf;
import com.d2d.service.intf.OfferServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.Response;

public class OfferService implements OfferServiceIntf {
    
	private MerchantServiceIntf merchantService = ServiceLocator.getServiceLocator().getMerchantService();
	private OfferDBMediatorIntf offerDBService = ServiceLocator.getServiceLocator().getOfferDBService();
    private OfferDatafileMediatorIntf offerDatafileService = ServiceLocator.getServiceLocator().getOfferDatafileService();
    private AffilateService affilateService = AffilateService.getInstance();
    
    public long createOffer(Offer offer) {
    	if(offer == null || offer.getEndDate() == null || offer.getEndDate().getTime() < System.currentTimeMillis() ){
			return -1;
    	}
		
    	List<Integer> categoriesId = offer.getCategories();
    	Set<Integer> parentCategoriesId = new HashSet<Integer>();
    	for (Integer categoryId : categoriesId) {
    		Category category = CategoryCache.getInstanse().getCategoryById(categoryId);
    		parentCategoriesId.add(category.getParent());
		}
    	for (Integer parentId : parentCategoriesId) {
    		categoriesId.add(parentId);
		}
    	
    	Merchant merchant = merchantService.getMerchantByMerchantID(offer.getMerchantId());
    	
    	String isImageURL = offer.getImageURL();
    	
    	/*if(offer.getImageURL() != null ){
    		String merchantImagePath = ImageConstant.MERCHANT_OFFER_IMG_PATH + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME;
    		if(offer.getImageURL().equalsIgnoreCase("false") && new File(merchantImagePath).exists()){
    			offer.setImageURL(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME);
    		}else{
    			offer.setImageURL(ImageConstant.DEFAULT_IMAGE);
    		}
    	}*/
    	
    	if(offer.getStartDate()==null)
      	  	offer.setStartDate(new Date());
    	if(offer.getContactNo()==null)
    		offer.setContactNo(merchant.getContactNo());
    	if(offer.getUrl() == null)    
    		offer.setUrl(merchant.getURL());
    	if(offer.getPromoCode()==null)
    		offer.setPromoCode(D2DConstant.PROMO_CODE_DEFAULT);
    	
    	if(offer.getPromoCode() == null || offer.getPromoCode().equalsIgnoreCase(D2DConstant.PROMO_CODE_DEFAULT) == false){
    		Filter filter = new Filter();
    		filter.setMerchantId(offer.getMerchantId());
    		filter.setPromoCode(offer.getPromoCode());
    		filter.setSummary(offer.getOfferSummary().trim());
    		filter.setStatus("A");
    		
        	Set<Offer> offerByFilter = offerDBService.getOffersByFilter(filter, false);
    		if(offerByFilter != null){
    			if(offerByFilter.isEmpty() == false || offerByFilter.size() > 0){
    				return -1;
    			}    				
    		}  
    	}
		offer = offerDBService.createOffer(offer);
		
		if(offer.getImageURL() != null ){
    		String merchantImagePath = ImageConstant.MERCHANT_OFFER_IMG_PATH + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME;
    		if(isImageURL.equalsIgnoreCase("false") && new File(merchantImagePath).exists()){
    			offer.setCoverImage(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME);
    			offer.setImageURL(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME);
    		}
    		else if(isImageURL.equalsIgnoreCase("true")){
    			offer.setCoverImage(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() +"/"+ offer.getIdx() +ImageConstant.OFFER_IMG_FILE_NAME);
    			offer.setImageURL(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() +"/"+ offer.getIdx() +ImageConstant.OFFER_IMG_FILE_NAME);
    		}
    		else{
    			offer.setCoverImage(ImageConstant.DEFAULT_IMAGE);
    			offer.setImageURL(ImageConstant.DEFAULT_IMAGE);
    		}
    	}
		
		offerDatafileService.createOffer(offer);
		offerDBService.updateImagePath(offer.getIdx(), offer.getImageURL());
		OfferCache.reloadCache();
		return offer.getIdx();
    }

    public String getOfferJSON(long providerId, long offerId) {
        try {
			return this.offerDatafileService.getOfferDetailJSON(providerId, offerId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }

    public Offer getOffer(long providerId, long offerId) {
        try {
			return this.offerDatafileService.getOfferDetailObject(providerId, offerId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }

    public Set<Offer> getOffersByFilter(Filter filter, boolean isORCondition) {
        HashSet<Offer> offers = new HashSet<Offer>();
        Set<Offer> offersDB = offerDBService.getOffersByFilter(filter,isORCondition);
        if(offersDB != null){
	        for (Offer offerDB : offersDB) {
	            try {
					Offer offerFromDatafile = offerDatafileService.getOfferSummaryObject(offerDB.getMerchantId(), offerDB.getIdx());
					offers.add(offerFromDatafile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}   			
	        }
        }
        return offers;
    }

    public List<Offer> getOffersFromCache() {
    	List<Offer> offersFromCache = OfferCache.getInstanse().getCachedOffers();
    	List<Offer> offers = new LinkedList<Offer>();
    	for (Offer offerFromCache : offersFromCache) {
    		try {
				Offer offerFromDatafile = offerDatafileService.getOfferSummaryObject(offerFromCache.getMerchantId(), offerFromCache.getIdx());
				offers.add(offerFromDatafile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
    	return offers;
    }

    public boolean updateOffer(Offer offer) {
        try {
        	if(offer == null || offer.getEndDate() == null || offer.getEndDate().getTime() < System.currentTimeMillis() ){
    			return false;
        	}
    		
        	/*List<Integer> categoriesId = offer.getCategories();
        	Set<Integer> parentCategoriesId = new HashSet<Integer>();
        	for (Integer categoryId : categoriesId) {
        		Category category = CategoryCache.getInstanse().getCategoryById(categoryId);
        		parentCategoriesId.add(category.getParent());
    		}
        	for (Integer parentId : parentCategoriesId) {
        		categoriesId.add(parentId);
    		}
        	*/
        	Merchant merchant = merchantService.getMerchantByMerchantID(offer.getMerchantId());
        	
        	String isImageURL = offer.getImageURL();
        	
        	if(offer.getStartDate()==null)
          	  	offer.setStartDate(new Date());
        	if(offer.getContactNo()==null)
        		offer.setContactNo(merchant.getContactNo());
        	if(offer.getUrl() == null)    
        		offer.setUrl(merchant.getURL());
        	if(offer.getPromoCode()==null)
        		offer.setPromoCode(D2DConstant.PROMO_CODE_DEFAULT);
        	
        	if(offer.getImageURL() != null ){
        		String merchantImagePath = ImageConstant.MERCHANT_OFFER_IMG_PATH + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME;
        		if(isImageURL.equalsIgnoreCase("false") && new File(merchantImagePath).exists()){
        			offer.setCoverImage(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME);
        			offer.setImageURL(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() + ImageConstant.MERCHANT_IMG_FILE_NAME);
        		}
        		else if(isImageURL.equalsIgnoreCase("true")){
        			offer.setCoverImage(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() +"/"+ offer.getIdx() +ImageConstant.OFFER_IMG_FILE_NAME);
        			offer.setImageURL(ImageConstant.MERCHANT_OFFER_IMG_URL + offer.getMerchantId() +"/"+ offer.getIdx() +ImageConstant.OFFER_IMG_FILE_NAME);
        		}
        		else{
        			offer.setCoverImage(ImageConstant.DEFAULT_IMAGE);
        			offer.setImageURL(ImageConstant.DEFAULT_IMAGE);
        		}
        	}
        	this.offerDatafileService.updateOffer(offer);
            this.offerDBService.updateOffer(offer);            
            OfferCache.reloadCache();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Response deleteOffer(long providerId, long offerId) {
        this.offerDBService.deleteOffer(offerId);
        this.offerDatafileService.deleteOffer(providerId, offerId);
        OfferCache.reloadCache();
        return new Response("success", "User successfully registered");
    }
    
    @Override
    public List<Category> getCategories() {
    	return this.offerDBService.getCategories();
    }
    
    @Override
    public Response createCategory(Category var1) {
    	Category categoryFromDB = this.offerDBService.addCategory(var1);
         if (categoryFromDB != null) {
             if (categoryFromDB.getIdx() != 0) {
            	 CategoryCache.getInstanse().addCategory(categoryFromDB);
            	 CategoryCache.reloadCache();
                 return new Response("id", categoryFromDB.getIdx() + "");
             }
         } else {
             return new Response("fail", "Category/SubCategory already registered");
         }
         return new Response("fail", "Something went wrong, please try again");
    }
    
    @Override
    public Response updateCategory(Category var1) {
    	try{
    		this.offerDBService.updateCategory(var1);
    		CategoryCache.reloadCache();
    		return new Response("success", "Category/SubCategory successfully updated");
    	}catch(Exception ex){
    		ex.printStackTrace();
    		return new Response("fail", "Something went wrong, please try again");
    	}
    	
    }
    
    @Override
    public Response deleteCategory(Integer var1) {
    	if(this.offerDBService.deleteCategory(var1)){
    		CategoryCache.reloadCategoryCache();
    		CategoryCache.reloadCache();
    		return new Response("success", "Category/SubCategory successfully deleted");
    	}
    	return  new Response("fail", "Something went wrong/delete subcategory or offers Exists so cat/subcat can not delete, please try again");
    }

    @Override
    public Category getCategory(Integer id) {
    	try {
 			return this.offerDBService.getCategoryById(id);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return null;
    }
    
	@Override
	public void executeAffilateAPI(String affilateName) {
		affilateService.executeAffilateAPI(affilateName);
		OfferCache.reloadCache();
	}

	@Override
	public void readAffilateCSV(String affilateName, String[] categories) {
		affilateService.readAffilateCSV(affilateName, categories);
		OfferCache.reloadCache();
	}

	@Override
	public List<Category> getAllCategoriesFromCache() {
		return CategoryService.getInstanse().getAllCategory();
	}
}

