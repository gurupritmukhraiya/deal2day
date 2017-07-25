package com.d2d.datafile.mediator.intf;

import java.io.FileNotFoundException;

import com.d2d.service.common.beans.Offer;

public interface OfferDatafileMediatorIntf {
    
	public void createOffer(Offer offer);
	
	public boolean offerExistInDataFile(long merchantId, long offerId);

    public String getOfferDetailJSON(long merchantId, long offerId) throws FileNotFoundException;

    public String getOfferSummaryJSON(long merchantId, long offerId) throws FileNotFoundException;

    public Offer getOfferSummaryObject(long merchantId, long offerId) throws FileNotFoundException;

    public Offer getOfferDetailObject(long merchantId, long offerId) throws FileNotFoundException;

    public void updateOffer(Offer offer);

    public void deleteOffer(long merchantId, long offerId);
}

