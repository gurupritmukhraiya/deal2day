package com.d2d.service.intf;

import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.util.Response;
import java.util.List;
import java.util.Set;

public interface OfferServiceIntf {
	
    public long createOffer(Offer var1);

    public String getOfferJSON(long var1, long var3);

    public Offer getOffer(long var1, long var3);

    public boolean updateOffer(Offer var1);

    public Set<Offer> getOffersByFilter(Filter var1, boolean var2);

    public List<Offer> getOffersFromCache();

    public Response deleteOffer(long var1, long var3);
    
    public List<Category> getCategories();
    
    public Response createCategory(Category var1);
    
    public Response updateCategory(Category var1);
    
    public Response deleteCategory(Integer var1);
    
    public void executeAffilateAPI(String affilateName);
    
    public void readAffilateCSV(String affilateName, String []category);
    
    public List<Category> getAllCategoriesFromCache();
    
    public Category getCategory(Integer var1);
}

