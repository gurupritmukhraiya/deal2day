package com.d2d.service;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import com.d2d.cache.MerchantNameCache;
import com.d2d.datafile.mediator.intf.OfferDatafileMediatorIntf;
import com.d2d.db.mediator.intf.MerchantDBMediatorIntf;
import com.d2d.db.mediator.intf.OfferDBMediatorIntf;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.intf.MerchantServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.Response;

public class MerchantService implements MerchantServiceIntf {
	
    private MerchantDBMediatorIntf merchantDBMediator = ServiceLocator.getServiceLocator().getMerchantDBService();
	private OfferDatafileMediatorIntf offerDatafileService = ServiceLocator.getServiceLocator().getOfferDatafileService();
	private OfferDBMediatorIntf offerDBService = ServiceLocator.getServiceLocator().getOfferDBService();

    public Response registerMerchant(Merchant merchant) {
        merchant.setStatus("A");
        merchant.setRole("MERCHANT_ROLE");
        Merchant merchantFromDB = this.merchantDBMediator.create(merchant);
        if (merchantFromDB != null) {
            if (merchantFromDB.getIdx() != 0) {
            	MerchantNameCache.getInstanse().addMerchantName(merchantFromDB.getMerchantName(), merchantFromDB.getIdx());
                return new Response("success", "User successfully registered");
            }
        } else {
            return new Response("fail", "Email id already registered");
        }
        return new Response("fail", "Something went wrong, please try again");
    }
    
    @Override
    public Response addMerchant(Merchant merchant) {
    	Merchant merchantFromDB = this.merchantDBMediator.create(merchant);
    	MerchantNameCache.reloadCache();
        if (merchantFromDB != null) {
            if (merchantFromDB.getIdx() != 0) {
                return new Response("id", merchantFromDB.getIdx() + "");
            }
            return new Response("fail", "Email id already registered");
        } else {
            return new Response("fail", "Email id already registered");
        }
    }

    public Response verifyMerchant(String emailId, String verificationCode) {
        Merchant merchant = this.merchantDBMediator.getMerchantByMerchantId(emailId);
        if (merchant != null && merchant.getStatus().equals(verificationCode)) {
            merchant.setStatus("A");
            this.merchantDBMediator.update(merchant);
            return new Response("success", "Email id successfully verified");
        }
        return new Response("fail", "Email id already registered");
    }

    public Merchant getMerchantWithAddressAndOffer(String loginId) {
    	Merchant merchant = merchantDBMediator.getMerchantWithAddressAndOffer(loginId);
    	List<Offer> offersFromDB = merchant.getOffers();
    	List<Offer> offersFromDatafile = new LinkedList<Offer>();
    	for (Offer offer : offersFromDB) {
			try{
				Offer offerSummary = offerDatafileService.getOfferSummaryObject(merchant.getIdx(), offer.getIdx());
				if(offerSummary != null){
					offersFromDatafile.add(offerSummary);	
				}else{
					System.out.println(merchant.getIdx() + offer.getIdx() + " offer not found in file system");
					System.out.println("removing offer from DB having ID : " + offer.getIdx());
					offerDBService.deleteOffer(offer.getIdx());
				}				
			}catch(FileNotFoundException e){
				System.out.println(merchant.getIdx() + offer.getIdx() + " offer not found in file system");
				System.out.println("removing offer from DB having ID : " + offer.getIdx());
				offerDBService.deleteOffer(offer.getIdx());
			}			
		}
    	merchant.setOffers(offersFromDatafile);
        return merchant;
    }

    public Response updateMerchant(Merchant merchant) {
        if (this.merchantDBMediator.update(merchant)) {
            return new Response("success", "profile successfully updated");
        }
        return new Response("fail", "profile can not update yet");
    }

	@Override
	public List<Merchant> getAllMerchants() {
		List<Merchant> merchants = merchantDBMediator.getAllMerchants();
    	/*List<Offer> offersFromDB = merchant.getOffers();
    	List<Offer> offersFromDatafile = new LinkedList<Offer>();
    	for (Offer offer : offersFromDB) {
			try{
				Offer offerSummary = offerDatafileService.getOfferSummaryObject(merchant.getIdx(), offer.getIdx());
				if(offerSummary != null){
					offersFromDatafile.add(offerSummary);	
				}else{
					System.out.println(merchant.getIdx() + offer.getIdx() + " offer not found in file system");
					System.out.println("removing offer from DB having ID : " + offer.getIdx());
					offerDBService.deleteOffer(offer.getIdx());
				}				
			}catch(FileNotFoundException e){
				System.out.println(merchant.getIdx() + offer.getIdx() + " offer not found in file system");
				System.out.println("removing offer from DB having ID : " + offer.getIdx());
				offerDBService.deleteOffer(offer.getIdx());
			}			
		}
    	merchant.setOffers(offersFromDatafile);*/
        return merchants;
	}
	
	@Override
    public Merchant getMerchantByMerchantID(long idx) {
		return merchantDBMediator.getMerchantByIdx(idx);
    }
	
	@Override
    public Response updateMerchantStatus(long id, String status) {
        if (this.merchantDBMediator.updateMerchantStatus(id, status)) {
            return new Response("success", "profile successfully updated");
        }
        return new Response("fail", "profile can not update yet");
    }
	
	@Override
    public Response addMerchantName(MerchantName merchantName) {
        MerchantName merchantNameDB = this.merchantDBMediator.createMerchantName(merchantName);
        if (merchantNameDB != null) {
            if (merchantNameDB.getIdx() != 0) {
            	MerchantNameCache.getInstanse().addMerchantName(merchantNameDB.getMerchantName(), merchantNameDB.getMerchantId());
            	MerchantNameCache.getInstanse().addMerchantNameWithoutId(merchantNameDB);
                return new Response("success", "Merchant Name successfully registered");
            }
        } else {
            return new Response("fail", "Merchant Name already registered");
        }
        return new Response("fail", "Something went wrong, please try again");
    }
   
    @Override
    public Response updateMerchantName(MerchantName merchant) {
        if (this.merchantDBMediator.updateMerchantName(merchant.getIdx(), merchant.getMerchantId())) {
        	MerchantNameCache.getInstanse().assignIdToMerchantName(merchant);
            return new Response("success", "Merchant Status successfully updated");
        }
        return new Response("fail", "Merchant Status can not update yet");
    }
    
    @Override
	public List<MerchantName> getAllMerchantNames() {
		return merchantDBMediator.getAllMerchantNames();
	}
}

