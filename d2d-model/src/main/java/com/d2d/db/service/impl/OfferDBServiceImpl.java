package com.d2d.db.service.impl;

import java.util.List;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.service.intf.OfferDBServiceIntf;
import com.d2d.model.beans.CategoryModel;
import com.d2d.model.beans.OfferModel;
import com.d2d.model.dao.intf.OfferDAOIntf;
import com.d2d.service.common.beans.Filter;

public class OfferDBServiceImpl implements OfferDBServiceIntf {
	
    private OfferDAOIntf offerDAOIntf;

    public OfferDAOIntf getOfferDAOIntf() {
        return this.offerDAOIntf;
    }

    public void setOfferDAOIntf(OfferDAOIntf offerDAOIntf) {
        this.offerDAOIntf = offerDAOIntf;
    }

    @Override
    public void create(OfferModel offerModel) throws DBServiceException {
        try {
            this.getOfferDAOIntf().create(offerModel);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public OfferModel getOfferById(long idx, boolean includeMerchant, boolean includeLocations) throws DBServiceException {
        try {
            return this.getOfferDAOIntf().getOfferById(idx, includeMerchant, includeLocations);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public void update(OfferModel offerModel) {
        try {
            this.getOfferDAOIntf().update(offerModel);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(long idx) throws DBServiceException {
        try {
            this.getOfferDAOIntf().delete(idx);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<OfferModel> getOffersByFilter(Filter filter, boolean includeMerchant, boolean includeLocations) throws DBServiceException {
        try {
            return this.getOfferDAOIntf().getOffersByFilter(filter, includeMerchant, includeLocations);
          }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }
    
    @Override
    public List<OfferModel> getOffersByOR(Filter filter,boolean includeMerchant, boolean includeLocations)
    		throws DBServiceException {
    	 return this.getOfferDAOIntf().getOffersByOR(filter, includeMerchant, includeLocations);
    }

	@Override
	public void addCategory(CategoryModel categoryModel) throws DBServiceException {
		try {
            this.getOfferDAOIntf().addCategory(categoryModel);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }		
	}

	@Override
	public List<CategoryModel> getCategories() throws DBServiceException {
		try {
            return getOfferDAOIntf().getCategories();
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
	}
	
	public CategoryModel getCategory(String var1, int var2) throws DBServiceException{
		try{
			return getOfferDAOIntf().getCategoryByName(var1, var2);
		}catch(Exception ex){
			throw new DBServiceException(ex);
		}
	}
	
	@Override
	public void updateCategory(CategoryModel var1) throws DBServiceException {
		try{
			this.getOfferDAOIntf().updateCategory(var1);
		}catch(Exception e){
			throw new DBServiceException(e);
		}	
	}
	
	@Override
	public List<CategoryModel> getCategoriesByParentId(Integer var1)
			throws DBServiceException {
		try{
			return this.getOfferDAOIntf().getCategoryParentIds(var1);
		}catch(Exception e){
			throw new DBServiceException(e);
		}	
	}
	
	@Override
	public void deleteCategory(Integer var1) throws DBServiceException {
		 try {
	            this.getOfferDAOIntf().deleteCategory(var1);
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }	
	}
	
	@Override
	public List<Integer> getCatIdsFromOfferCategoryTable(Integer var1)
			throws DBServiceException {
		try{
			return this.getOfferDAOIntf().getCatIdsFromOfferCategoryTable(var1);
		}catch(Exception e){
			throw new DBServiceException(e);
		}	
	}
	
	@Override
	public void updateCategoryOffer(String var1, Integer var2)
			throws DBServiceException {
		try{
			this.getOfferDAOIntf().updateOfferCatNotExist(var1, var2);
		}catch(Exception e){
			throw new DBServiceException(e);
		}		
	}
	
	@Override
	public CategoryModel getCatgoryById(Integer id) throws DBServiceException {
		try{
			return this.getOfferDAOIntf().getCategoryById(id);
		}catch(Exception ex){
			throw new DBServiceException(ex);
	  }
	}
	
	@Override
	public void updateImagePath(long offerIdx, String imagePath)
			throws DBServiceException {
		try{
			this.getOfferDAOIntf().updateImage(offerIdx, imagePath);
		}catch(Exception e){
			throw new DBServiceException(e);
		}	
	}
}

