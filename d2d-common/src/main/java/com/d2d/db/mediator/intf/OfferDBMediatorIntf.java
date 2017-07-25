package com.d2d.db.mediator.intf;

import java.util.List;
import java.util.Set;

import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Offer;

public interface OfferDBMediatorIntf {
	
    public Offer createOffer(Offer offer);

    public Offer getOfferByOfferId(long var1, boolean var3, boolean var4);

    public void updateOffer(Offer offer);

    public void deleteOffer(long idx);

    public Set<Offer> getOffersByFilter(Filter filter, boolean var1);
    
    public boolean updateImagePath(long var1, String var2);
    
    //Category
    public Category addCategory(Category category);
    
    public List<Category> getCategories();
    
    public  boolean isCategoryExist(String var1, int var2);
    
    public void updateCategory(Category var1);
    
    public boolean isCategoryExist(Integer var1);
    
    public boolean deleteCategory(Integer var1); 
    
    public boolean getCategoryIdsFromOC(Integer var1);
    
    public Category getCategoryById(Integer var1);
    
    public boolean isDuplicateOffer(Filter filter);
}


