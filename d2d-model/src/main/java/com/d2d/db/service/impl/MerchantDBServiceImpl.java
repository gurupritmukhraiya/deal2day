package com.d2d.db.service.impl;

import java.util.List;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.service.intf.MerchantDBServiceIntf;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.MerchantNameModel;
import com.d2d.model.beans.MerchantProfile;
import com.d2d.model.dao.intf.MerchantDAOIntf;

public class MerchantDBServiceImpl implements MerchantDBServiceIntf {
	
    private MerchantDAOIntf merchantDAOIntf;

    public MerchantDAOIntf getMerchantDAOIntf() {
        return this.merchantDAOIntf;
    }

    public void setMerchantDAOIntf(MerchantDAOIntf merchantDAOIntf) {
        this.merchantDAOIntf = merchantDAOIntf;
    }

    @Override
    public void create(MerchantLogin providerLogin) throws DBServiceException {
        try {
            this.getMerchantDAOIntf().create(providerLogin);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public MerchantLogin getMerchantById(long idx, boolean isFetchLocation, boolean isFetchOffer) throws DBServiceException {
        try {
            return this.getMerchantDAOIntf().getMerchantById(idx, isFetchLocation, isFetchOffer);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public MerchantLogin getMerchantByLoginId(String loginId, boolean isFetchLocation, boolean isFetchOffer) throws DBServiceException {
        try {
            return this.getMerchantDAOIntf().getMerchantByLoginId(loginId, isFetchLocation, isFetchOffer);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public void update(MerchantLogin merchantLogin) throws DBServiceException {
        try {
            this.getMerchantDAOIntf().update(merchantLogin);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

	@Override
	public List<MerchantLogin> getAllMerchants() throws DBServiceException {
		try {
            return getMerchantDAOIntf().getAllMerchants();
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
	} 
	
	@Override
    public List<MerchantNameModel> getAllMerchantNames() throws DBServiceException {
         try {
             return this.getMerchantDAOIntf().getAllMerchantName();
          } catch (Exception ex) {
              throw new DBServiceException(ex);
          }
    }
   
    @Override
    public void createMerchantName(MerchantNameModel merchantName) throws DBServiceException {
         try {
             this.getMerchantDAOIntf().createMerchantName(merchantName);
         } catch (Exception ex) {
             throw new DBServiceException(ex);
         }
    }
   
    @Override
    public MerchantNameModel getMerchantByName(String name) throws DBServiceException{
        try {
            return this.getMerchantDAOIntf().getMerchantByName(name);
        } catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }
   
    @Override
    public void updateMerchantName(long var1, long var2)
            throws DBServiceException {
        try {
            this.getMerchantDAOIntf().updateMerchantName(var1, var2);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }
    
    @Override
    public List<MerchantProfile> getMerchants() throws DBServiceException {
    	try {
            return this.getMerchantDAOIntf().getMerchants();
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

	@Override
	public boolean isMerchantNameExist(String merchantName)	throws DBServiceException {
		try {
            return this.getMerchantDAOIntf().isMerchantNameExist(merchantName);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
	}
}

