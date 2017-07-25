package com.d2d.db.mediator.impl;

import java.util.ArrayList;
import java.util.List;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.mediator.intf.MerchantDBMediatorIntf;
import com.d2d.db.service.intf.MerchantDBServiceIntf;
import com.d2d.model.bean.factory.MerchantBeanFactory;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.MerchantNameModel;
import com.d2d.model.beans.MerchantProfile;
import com.d2d.model.util.MerchantDBHelper;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;

public class MerchantDBMediatorImpl implements MerchantDBMediatorIntf {
    
	MerchantDBServiceIntf merchantDBService = MerchantBeanFactory.getProviderDBService();
    MerchantDBHelper merchantDBHelper = MerchantDBHelper.getInstance();

    public Merchant create(Merchant merchant) {
    	try {
	        if (!this.isMerchantExist(merchant.getEmailId()) && !merchantDBService.isMerchantNameExist(merchant.getMerchantName())) {
	            MerchantLogin merchantLogin = this.merchantDBHelper.getMerchantLoginByMerchant(merchant, false);
	            if (merchantLogin != null) {
                    this.merchantDBService.create(merchantLogin);
                    merchant.setIdx(merchantLogin.getIdx().longValue());
	            }
	        } else {
	            return null;
	        }
        }catch (DBServiceException e) {
            e.printStackTrace();
            return null;
        }
        return merchant;
    }

    public boolean isMerchantExist(String loginId) {
        try {
            if (this.merchantDBService.getMerchantByLoginId(loginId, false, false) != null) {
                return true;
            }
        }
        catch (DBServiceException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Merchant getMerchantWithAddressAndOffer(String loginId) {
        Merchant merchant = null;
        try {
            MerchantLogin merchantLogin = this.merchantDBService.getMerchantByLoginId(loginId, true, true);
            merchant = this.merchantDBHelper.getMerchantByMerchantLogin(merchantLogin, true, true);
        }
        catch (DBServiceException e) {
            e.printStackTrace();
        }
        return merchant;
    }

    public boolean update(Merchant merchant) {
        try {
            MerchantLogin merchantLoginFromDB = this.merchantDBService.getMerchantByLoginId(merchant.getEmailId(), false, false);
            if (merchant.getURL() != null) {
                merchantLoginFromDB.getMerchantProfile().setURL(merchant.getURL());
            }
            if (merchant.getImagePath() != null) {
                merchantLoginFromDB.getMerchantProfile().setImagePath(merchant.getImagePath());
            }
            if (merchant.getContactNo() != null) {
                merchantLoginFromDB.getMerchantProfile().setContactNo(merchant.getContactNo());
            }
            if (merchant.getStatus() != null) {
                merchantLoginFromDB.setStatus(merchant.getStatus());
            }
            if (merchant.getPassword() != null) {
                if (!merchantLoginFromDB.getPassword().equals(merchant.getOldPassword())) {
                    return false;
                }
                merchantLoginFromDB.setPassword(merchant.getPassword());
            }
            this.merchantDBService.update(merchantLoginFromDB);
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public Merchant getMerchantByMerchantId(String loginId) {
        Merchant merchant = null;
        try {
            MerchantLogin merchantLogin = this.merchantDBService.getMerchantByLoginId(loginId, false, false);
            merchant = this.merchantDBHelper.getMerchantByMerchantLogin(merchantLogin, false, false);
        }
        catch (DBServiceException e) {
            e.printStackTrace();
        }
        return merchant;
    }

	@Override
	public List<Merchant> getAllMerchants(){
		List<Merchant> merchants = new ArrayList<Merchant>();
        try {
            List<MerchantLogin> merchantsFromDB = this.merchantDBService.getAllMerchants();
            for (MerchantLogin merchant : merchantsFromDB) {
            	merchants.add(merchantDBHelper.getMerchantByMerchantLogin(merchant, false, false));	
			}            
        }
        catch (DBServiceException e) {
            e.printStackTrace();
        }
        return merchants;
	}
	
	@Override
    public Merchant getMerchantByIdx(long idx) {
         Merchant merchant = null;
         try {
             MerchantLogin merchantLogin = this.merchantDBService.getMerchantById(idx, false, false);
             merchant = this.merchantDBHelper.getMerchantByMerchantLogin(merchantLogin, false, false);
         }
         catch (DBServiceException e) {
             e.printStackTrace();
         }
         return merchant;
    }
	
	@Override
    public boolean updateMerchantStatus(long idx, String status) {
        try {
            MerchantLogin merchantLoginFromDB = this.merchantDBService.getMerchantById(idx, false, false);
            merchantLoginFromDB.setStatus(status);
            this.merchantDBService.update(merchantLoginFromDB);
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
	@Override
    public List<MerchantName> getAllMerchantNames() {
        List<MerchantName> merchantList = null;
        try{
            merchantList = new ArrayList<MerchantName>();
            List<MerchantNameModel> merchantListDB = this.merchantDBService.getAllMerchantNames();
            if(merchantListDB != null){
                for(MerchantNameModel merchant : merchantListDB){
                    MerchantName merchantName = this.merchantDBHelper.getMerchantNameByMerchantNameModel(merchant);
                    merchantList.add(merchantName);
                }
                return merchantList;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


 @Override
    public MerchantName createMerchantName(MerchantName merchantName) {
         if (!this.isMerchantNameExist(merchantName.getMerchantName())) {
             MerchantNameModel merchantNameModel = this.merchantDBHelper.getMerchantNameModelByMerchantName(merchantName);
             if (merchantNameModel != null) {
                 try {
                     this.merchantDBService.createMerchantName(merchantNameModel);
                     merchantName.setIdx(merchantNameModel.getIdx());
                 }
                 catch (DBServiceException e) {
                     e.printStackTrace();
                     return null;
                 }
             }
         }else {
             return null;
         }
         return merchantName;
    }
   
    @Override
    public boolean isMerchantNameExist(String name) {
         try {
             if (this.merchantDBService.getMerchantByName(name.trim()) != null) {
                 return true;
             }
         }
         catch (DBServiceException e) {
             e.printStackTrace();
         }
         return false;
    }
   
    @Override
    public boolean updateMerchantName(long id, long merchantId) {
         try {
              this.merchantDBService.updateMerchantName(id, merchantId);
              return true;
         }
         catch (DBServiceException e) {
             e.printStackTrace();
         }
         return false;
    }
    
    @Override
    public List<MerchantName> getMerchants() {
    	List<MerchantName> merchantList = null;
        try{
            merchantList = new ArrayList<MerchantName>();
            List<MerchantProfile> merchantListDB = this.merchantDBService.getMerchants();
            if(merchantListDB != null){
            	MerchantName  merchantName = null;
                for(MerchantProfile merchant : merchantListDB){
                	merchantName =  new MerchantName();
                	merchantName.setMerchantId(merchant.getIdx());
                	merchantName.setMerchantName(merchant.getMerchantName());
                    merchantList.add(merchantName);
                }
                return merchantList;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}

