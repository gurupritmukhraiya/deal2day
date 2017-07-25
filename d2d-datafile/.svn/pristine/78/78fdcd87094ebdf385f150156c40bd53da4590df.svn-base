package com.d2d.datafile.core.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.d2d.datafile.util.OfferDatafileUtil;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.util.JSONUtil;

public class OfferDatafileObject {
	
	OfferDatafileUtil util = OfferDatafileUtil.getInstance();
	
    public void createUpdateOfferSummary(Offer offer) {
    	util.preparePath(offer.getMerchantId(), offer.getIdx());
        JSONUtil.getInstanse().write(util.getSummaryFileWithPath(offer.getMerchantId(), offer.getIdx()), offer);
    }

    public void createUpdateOfferDetail(Offer offer) {
    	util.preparePath(offer.getMerchantId(), offer.getIdx());
        JSONUtil.getInstanse().write(util.getDetailFileWithPath(offer.getMerchantId(), offer.getIdx()), offer);
    }

    public String getOfferSummaryJSON(long merchantIdx, long offerIdx) {
    	if(new File(util.getDetailFileWithPath(merchantIdx, offerIdx)).exists()){
    		return JSONUtil.getInstanse().read(util.getSummaryFileWithPath(merchantIdx, offerIdx));
    	}
    	return null;
    }

    public String getOfferDetailJSON(long merchantIdx, long offerIdx) {
    	if(new File(util.getDetailFileWithPath(merchantIdx, offerIdx)).exists()){
    		return JSONUtil.getInstanse().read(util.getDetailFileWithPath(merchantIdx, offerIdx));
    	}
    	return null;
    }
    
    public Offer getOfferSummaryObject(long merchantIdx, long offerIdx) throws IOException {
    	if(new File(util.getDetailFileWithPath(merchantIdx, offerIdx)).exists()){
			return (Offer)JSONUtil.getInstanse().read(util.getSummaryFileWithPath(merchantIdx, offerIdx), Offer.class);
		}
		return null;
    }

    public Offer getOfferDetailObject(long merchantIdx, long offerIdx) throws IOException {
    	if(new File(util.getDetailFileWithPath(merchantIdx, offerIdx)).exists()){
    		return (Offer)JSONUtil.getInstanse().read(util.getDetailFileWithPath(merchantIdx, offerIdx), Offer.class);
    	}
    	return null;
    }

    public void deleteOffer(long merchantIdx, long offerId) {
        try {
            FileUtils.deleteDirectory((File)new File(util.getPath(merchantIdx, offerId)));
        }catch(FileNotFoundException e){
        	System.out.println(util.getPath(merchantIdx, offerId) + "offer does not exist..");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean offerExists(long merchantIdx, long offerIdx){
    	return (new File(util.getDetailFileWithPath(merchantIdx, offerIdx)).exists()) 
    			&& (new File(util.getSummaryFileWithPath(merchantIdx, offerIdx)).exists()); 
    }
}

