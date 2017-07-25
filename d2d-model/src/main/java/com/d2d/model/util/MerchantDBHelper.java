package com.d2d.model.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

import com.d2d.constants.D2DConstant;
import com.d2d.constants.ImageConstant;
import com.d2d.model.beans.LocationModel;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.MerchantNameModel;
import com.d2d.model.beans.MerchantProfile;
import com.d2d.model.beans.OfferModel;
import com.d2d.service.common.beans.Location;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;
import com.d2d.service.common.beans.Offer;

public class MerchantDBHelper {
	
    private static MerchantDBHelper merchantDBHelper;

    private MerchantDBHelper() {
    }

    public static MerchantDBHelper getInstance() {
        if (merchantDBHelper == null) {
            merchantDBHelper = new MerchantDBHelper();
        }
        return merchantDBHelper;
    }

    public MerchantLogin getMerchantLoginByMerchant(Merchant merchant, boolean isAddId) {
        MerchantLogin merchantLogin = null;
        if (merchant != null) {
            merchantLogin = new MerchantLogin();
            merchantLogin.setMerchantId(merchant.getEmailId());
            merchantLogin.setPassword(merchant.getPassword());
            merchantLogin.setRole(merchant.getRole());
            merchantLogin.setStatus(merchant.getStatus());
            MerchantProfile merchantProfile = new MerchantProfile();
            merchantProfile.setContactNo(merchant.getContactNo());
            merchantProfile.setEmail(merchant.getEmailId());
            merchantProfile.setMerchantName(merchant.getMerchantName());
            merchantProfile.setCreateDate(new Date());
            merchantProfile.setCreatedBy(merchant.getCreatedBy());
            merchantProfile.setImagePath(merchant.getImagePath());
            merchantProfile.setURL(merchant.getURL());
            if(merchant.getURL() == null)
            	merchantProfile.setURL(D2DConstant.URL_DEFAULT);
            if(merchant.getImagePath() == null){
            	merchantProfile.setImagePath(ImageConstant.DEFAULT_IMAGE);
            }            
            merchantLogin.setMerchantProfile(merchantProfile);
            if (isAddId) {
                merchantLogin.setIdx(merchant.getIdx());
            }
        }
        return merchantLogin;
    }

    public Merchant getMerchantByMerchantLogin(MerchantLogin merchantLogin, boolean isAddLocation, boolean isAddOffer) {
        Merchant merchant = null;
        if (merchantLogin != null) {
            merchant = new Merchant();
            merchant.setContactNo(merchantLogin.getMerchantProfile().getContactNo());
            merchant.setCreatedDate(merchantLogin.getMerchantProfile().getCreateDate());
            merchant.setEmailId(merchantLogin.getMerchantProfile().getEmail());
            merchant.setMerchantName(merchantLogin.getMerchantProfile().getMerchantName());
            merchant.setRole(merchantLogin.getRole());
            merchant.setStatus(merchantLogin.getStatus());
            merchant.setIdx(merchantLogin.getIdx());
            merchant.setPassword(merchantLogin.getPassword());
            merchant.setCreatedBy(merchantLogin.getMerchantProfile().getCreatedBy());
            merchant.setURL(merchantLogin.getMerchantProfile().getURL());
            merchant.setImagePath(merchantLogin.getMerchantProfile().getImagePath());
            if (isAddLocation) {
                LinkedList<Location> locations = new LinkedList<Location>();
                Set<LocationModel> locationModels = merchantLogin.getLocation();
                for (LocationModel locationModel : locationModels) {
                    Location location = LocationDBHelper.getInstance().getLocationByLocationModel(locationModel);
                    locations.add(location);
                }
                merchant.setLocations(locations);
            }
            if (isAddOffer) {
                LinkedList<Offer> offers = new LinkedList<Offer>();
                Set<OfferModel> offerModels = merchantLogin.getOffers();
                for (OfferModel offerModel : offerModels) {
                    Offer offer = OfferDBHelper.getInstance().getOfferByOfferModel(offerModel, false, false);
                    offers.add(offer);
                }
                merchant.setOffers(offers);
            }
        }
        return merchant;
    }
    
    public MerchantName getMerchantNameByMerchantNameModel(MerchantNameModel providerModel){
        MerchantName providerName = null;
        if(providerModel != null){
            providerName = new MerchantName();
            providerName.setMerchantName(providerModel.getPname());
            providerName.setMerchantId(providerModel.getMerchantId());
            providerName.setIdx(providerModel.getIdx());
        }
        return providerName;
    }
   
    public MerchantNameModel getMerchantNameModelByMerchantName(MerchantName merchantName){
        MerchantNameModel merchantNameModel = null;
        if(merchantName != null){
            merchantNameModel = new MerchantNameModel();
            merchantNameModel.setPname(merchantName.getMerchantName().trim());
            if(merchantName.getMerchantId()==0)
                merchantNameModel.setMerchantId(-1);
            else
                merchantNameModel.setMerchantId(merchantName.getMerchantId());
        }
        return merchantNameModel;
    }

}

