package com.d2d.datafile.util;

import com.d2d.constants.DatafileConstant;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.util.FolderUtil;

/**
 * 
 */

/**
 * @author guruprit_mukhraiya
 *
 */
public class OfferDatafileUtil {

	 private static OfferDatafileUtil offerDatafileUtil;

	 private OfferDatafileUtil() {
	 }

	 public static OfferDatafileUtil getInstance() {
		 if (offerDatafileUtil == null) {
			 offerDatafileUtil = new OfferDatafileUtil();
		 }
		 return offerDatafileUtil;
	 }
	 
	 public String getPath(long providerId, long offerId) {
		 return DatafileConstant.OFFER_PATH + providerId + "/" + offerId;
	 }
	    
	 public String getSummaryFileWithPath(long providerId, long offerId) {
		 return getPath(providerId, offerId) + DatafileConstant.SUMMARY_XML_FILE_NAME;
	 }
	    
	 public String getDetailFileWithPath(long providerId, long offerId) {
		 return getPath(providerId, offerId) + DatafileConstant.DETAIL_XML_FILE_NAME;
	 }

	 public void preparePath(long merchantId, long offerId) {
		 String path = getPath(merchantId, offerId);
		 FolderUtil.createFolders(path);
	 }
	 
	 public Offer convertToOfferSummary(Offer offer){
		 offer.setCategories(null);
		 offer.setCreatedDate(null);
		 offer.setDescription(null);
		 offer.setLocations(null);
		 offer.setTermsAndConditions(null);
		 return offer;
	 }
}
