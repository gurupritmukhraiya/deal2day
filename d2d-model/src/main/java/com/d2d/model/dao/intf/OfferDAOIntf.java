package com.d2d.model.dao.intf;

import java.util.List;

import com.d2d.db.exception.DBServiceException;
import com.d2d.model.beans.CategoryModel;
import com.d2d.model.beans.MerchantProfile;
import com.d2d.model.beans.OfferModel;
import com.d2d.service.common.beans.Filter;

public interface OfferDAOIntf {
    public void create(OfferModel var1) throws DBServiceException;

    public OfferModel getOfferById(long var1, boolean var3, boolean var4) throws DBServiceException;

    public void update(OfferModel var1) throws DBServiceException;

    public void delete(long var1) throws DBServiceException;

    public List<OfferModel> getOffersByFilter(Filter filter, boolean includeMerchant, boolean includeLocations) throws DBServiceException;

    public List<OfferModel> getOffersByOR(Filter filter, boolean includeMerchant, boolean includeLocations) throws DBServiceException;
	
    public void updateImage(long var1, String var2) throws DBServiceException;
    /**
	 * @param categoryModel
	 * @return
	 */
	public void addCategory(CategoryModel categoryModel) throws DBServiceException;

	public List<CategoryModel> getCategories() throws DBServiceException;
	
	public CategoryModel getCategoryByName(String var1, int var2) throws DBServiceException;
	
	public void updateCategory(CategoryModel var1) throws DBServiceException;
	
	public List<CategoryModel> getCategoryParentIds(Integer var1) throws DBServiceException;
	
	public void deleteCategory(Integer var1) throws DBServiceException;
	
	public List<Integer> getCatIdsFromOfferCategoryTable(Integer var1) throws DBServiceException;
	
	public void updateOfferCatNotExist(String var1, Integer var2) throws DBServiceException;
	
	public CategoryModel getCategoryById(Integer var1) throws DBServiceException;
}

