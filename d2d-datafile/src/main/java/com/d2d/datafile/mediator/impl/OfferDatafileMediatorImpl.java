package com.d2d.datafile.mediator.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.d2d.datafile.core.impl.OfferDatafileObject;
import com.d2d.datafile.mediator.intf.OfferDatafileMediatorIntf;
import com.d2d.datafile.util.OfferDatafileUtil;
import com.d2d.service.common.beans.Offer;

public class OfferDatafileMediatorImpl implements OfferDatafileMediatorIntf {
	
    private static OfferDatafileObject offerDFAO = new OfferDatafileObject();

    public void createOffer(Offer offer) {
        offerDFAO.createUpdateOfferDetail(offer);
        offerDFAO.createUpdateOfferSummary(OfferDatafileUtil.getInstance().convertToOfferSummary(offer));
    }

    public String getOfferDetailJSON(long merchantIdx, long offerIdx) throws FileNotFoundException{
        return offerDFAO.getOfferDetailJSON(merchantIdx, offerIdx);
    }

    public String getOfferSummaryJSON(long merchantIdx, long offerIdx) throws FileNotFoundException{
        return offerDFAO.getOfferSummaryJSON(merchantIdx, offerIdx);
    }

    public Offer getOfferSummaryObject(long merchantIdx, long offerIdx) throws FileNotFoundException {
    	try{
    		return offerDFAO.getOfferSummaryObject(merchantIdx, offerIdx);
    	}catch(FileNotFoundException e){
    		throw new FileNotFoundException();
    	} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }

    public Offer getOfferDetailObject(long merchantIdx, long offerIdx) throws FileNotFoundException{
        try {
			return offerDFAO.getOfferDetailObject(merchantIdx, offerIdx);
		} catch (IOException e) {
			if(e instanceof FileNotFoundException) {
				throw new FileNotFoundException();
			}
		}
		return null;
    }

    public void updateOffer(Offer offer) {
        this.createOffer(offer);
    }

    public void deleteOffer(long providerId, long offerId) {
        offerDFAO.deleteOffer(providerId, offerId);
    }

	@Override
	public boolean offerExistInDataFile(long merchantId, long offerId) {
		return offerDFAO.offerExists(merchantId, offerId);
	}
}

