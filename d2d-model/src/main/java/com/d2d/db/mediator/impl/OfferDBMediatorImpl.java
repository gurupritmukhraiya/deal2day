package com.d2d.db.mediator.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.mediator.intf.OfferDBMediatorIntf;
import com.d2d.db.service.intf.OfferDBServiceIntf;
import com.d2d.model.bean.factory.OfferBeanFactory;
import com.d2d.model.beans.CategoryModel;
import com.d2d.model.beans.OfferModel;
import com.d2d.model.util.CategoryDBHelper;
import com.d2d.model.util.OfferDBHelper;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Offer;

public class OfferDBMediatorImpl implements OfferDBMediatorIntf {
	
    OfferDBServiceIntf offerDBIntf = OfferBeanFactory.getOfferDBService();
    OfferDBHelper offerDBHelper = OfferDBHelper.getInstance();

    @Override
    public Offer createOffer(Offer offer) {
        try {
        	boolean isOfferHasLocation = offer.getLocations() != null;
            OfferModel offerModel = this.offerDBHelper.getOfferModelByOffer(offer, true, isOfferHasLocation, true, false);
            offerDBIntf.create(offerModel);
            offer.setIdx(offerModel.getIdx());
        }
        catch (DBServiceException e) {
            e.printStackTrace();
        }
        return offer;
    }

    @Override
    public Offer getOfferByOfferId(long idx, boolean includeMerchant, boolean includeLocations) {
        OfferModel offerModel = null;
        try {
            offerModel = this.offerDBIntf.getOfferById(idx, includeMerchant, includeLocations);
            if (offerModel != null) {
                return this.offerDBHelper.getOfferByOfferModel(offerModel, includeMerchant, includeLocations);
            }
        }
        catch (DBServiceException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOffer(Offer offer) {
        try {
            OfferModel offerModel = this.offerDBHelper.getOfferModelByOffer(offer, true, true, true, true);
            this.offerDBIntf.update(offerModel);
        }
        catch (DBServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteOffer(long idx) {
        try {
            this.offerDBIntf.delete(idx);
        }
        catch (DBServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Set<Offer> getOffersByFilter(Filter filter, boolean isORCondition) {
        List<OfferModel> offerModels = null;
        try {
        	if(isORCondition)
        		offerModels = this.offerDBIntf.getOffersByOR(filter, true, false);
        	else
                offerModels = this.offerDBIntf.getOffersByFilter(filter, true, false);
            HashSet<Offer> offers = new HashSet<Offer>();
            if (offerModels != null) {
                for (OfferModel offerModel : offerModels) {
                    Offer offer = this.offerDBHelper.getOfferByOfferModel(offerModel, true, false);
                    offers.add(offer);
                }
                return offers;
            }
        }
        catch (DBServiceException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean isDuplicateOffer(Filter filter) {
    	 List<OfferModel> offerModels = null;
         try {
             offerModels = this.offerDBIntf.getOffersByFilter(filter, false, false);
             if(offerModels.isEmpty()){
            	 return true; 
             }     
         }
         catch (DBServiceException ex) {
             ex.printStackTrace();
         }
         return false;
    }

	@Override
	public Category addCategory(Category category) {
		
		 if (!this.isCategoryExist(category.getName(),category.getParent())) {
	            CategoryModel categoryModel = this.offerDBHelper.getCategoryModelByCategory(category, false);
	            if (categoryModel != null) {
	                try {
	                    this.offerDBIntf.addCategory(categoryModel);
	                    category.setIdx(categoryModel.getIdx());
	                }
	                catch (DBServiceException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        } else {
	            return null;
	        }
	        return category;
		
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
        try {
            List<CategoryModel> categoryModels = offerDBIntf.getCategories();
            if (categoryModels != null) {
                for (CategoryModel categoryModel : categoryModels) {
                	Category category = CategoryDBHelper.getInstance().getCategoryByCategoryModel(categoryModel);
                	categories.add(category);
                }
                return categories;
            }
        }
        catch (DBServiceException ex) {
            ex.printStackTrace();
        }
        return null;
	}
	
	public boolean isCategoryExist(String var1, int var2){
		 try {
	            if (this.offerDBIntf.getCategory(var1, var2) != null) {
	                return true;
	            }
	        }
	        catch (DBServiceException e) {
	            e.printStackTrace();
	        }
	        return false;
	}
	
	@Override
	public void updateCategory(Category var1) {
		try{
			CategoryModel catModel = this.offerDBHelper.getCategoryModelByCategory(var1, true);
			this.offerDBIntf.updateCategory(catModel);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public boolean isCategoryExist(Integer var1) {
		 try {
	          if (this.offerDBIntf.getCategoriesByParentId(var1)!= null) {
	          return true;
	          }
	        }
	        catch (DBServiceException e) {
	            e.printStackTrace();
	        }
	        return false;
	}
	
	@Override
	public boolean deleteCategory(Integer var1) {
		  try {
			  	if(this.offerDBIntf.getCategoriesByParentId(var1).isEmpty()){
			  		if(this.getCategoryIdsFromOC(var1))
			  		this.offerDBIntf.deleteCategory(var1);
			  	return true;
			  	}
	        }
	        catch (DBServiceException ex) {
	            ex.printStackTrace();
	        }
		return false;
	}
	
	@Override
	public boolean getCategoryIdsFromOC(Integer var1) {
		 try {
	          if (this.offerDBIntf.getCatIdsFromOfferCategoryTable(var1).isEmpty()) {
	          return true;
	          }
	        }
	        catch (DBServiceException e) {
	            e.printStackTrace();
	        }
	        return false;
	}
	

	@Override
	public Category getCategoryById(Integer id) {
		CategoryModel catModel = null;
        try {
        	catModel = this.offerDBIntf.getCatgoryById(id);
            if (catModel != null) {
                return this.offerDBHelper.getCategoryByCategoryModel(catModel);
            }
        }
        catch (DBServiceException ex) {
            ex.printStackTrace();
        }
        return null;
	}
	
	@Override
	public boolean updateImagePath(long offerIdx, String imagePath) {
		try{
			this.offerDBIntf.updateImagePath(offerIdx, imagePath);
			return true;
		}catch(DBServiceException ex){
			ex.printStackTrace();
			return false;
		}
	}
	
}

