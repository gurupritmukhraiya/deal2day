package com.d2d.affilate.datafile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.d2d.cache.MerchantNameCache;
import com.d2d.constants.DatafileConstant;
import com.d2d.constants.ImageConstant;
import com.d2d.service.common.beans.MerchantName;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.intf.MerchantServiceIntf;
import com.d2d.service.intf.OfferServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.CSVUtil;
import com.d2d.service.util.DateUtil;
import com.d2d.service.util.FolderUtil;

public class AffilateCSVUtil {
	
	private static AffilateCSVUtil affilateCSVUtil;
	private OfferServiceIntf offerService = ServiceLocator.getServiceLocator().getOfferService();
	private MerchantServiceIntf merchantService = ServiceLocator.getServiceLocator().getMerchantService();
	private MerchantNameCache merchantNameCache = MerchantNameCache.getInstanse();
	
	private AffilateCSVUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static AffilateCSVUtil getInstance() {
		if(affilateCSVUtil == null){
			affilateCSVUtil = new AffilateCSVUtil();
		}
		return affilateCSVUtil;
	}
	
	public void readPayoom(String []categories) {
		System.out.println("Reading CSV");
		String csvFile = DatafileConstant.COUPON_CSV_LOCATION + "PAYOOM/" + DatafileConstant.COUPON_CSV_FILE_NAME;
		List<String[]> rows = CSVUtil.getInstanse().readCSV(csvFile);
		for (String[] row : rows) {
			
			String merchantName = row[0].trim();
			String title = row[1].trim();
			String promoCode = row[2].trim();
			String startDate = row[3].trim();
			String endDate = row[4].trim();
			String url = row[5].trim();
			
			boolean isMerchantNameExist = merchantNameCache.isMerchantNameExist(merchantName);
			System.out.println("Merchant Exist" + isMerchantNameExist);
			if(isMerchantNameExist){
				Long merchantId = merchantNameCache.getMerchantId(merchantName);
				if(merchantId != -1){
					System.out.println("Creating Offer");
					Offer offer = new Offer();
					offer.setStartDate(DateUtil.getDateFromAnyFormat(startDate));
					offer.setEndDate(DateUtil.getDateFromAnyFormat(endDate));
					offer.setCouponPrice(0);
					offer.setRating(0);
					offer.setCreatedDate(new Date());
					offer.setOfferSummary(title);
					
					offer.setImageURL("NA");	
					
					offer.setPromoCode(promoCode);
					offer.setUrl(url);
					offer.setMerchantId(merchantId);
					offer.setStatus("A");
					
					List<Integer> categoriesList = new ArrayList<Integer>();
					for (String category : categories) {
						categoriesList.add(Integer.parseInt(category));
					}
					
					/*List<Long> locations = new ArrayList<Long>();
					locations.add(1L);
					
					offer.setLocations(locations);
					*/offer.setCategories(categoriesList);
					
					offerService.createOffer(offer);	 
					
					System.out.println("Offer Created");
				}
			}else{
				System.out.println("Adding Merchant name to DB");
				MerchantName merchantNameObj = new MerchantName();
				merchantNameObj.setMerchantId(-1);
				merchantNameObj.setMerchantName(merchantName);
				merchantService.addMerchantName(merchantNameObj);
			}			
		}
	}
	
	public void readVComission(String []categories) {
		String path = DatafileConstant.COUPON_CSV_LOCATION + "VCOMISSION/" + DatafileConstant.COUPON_CSV_FILE_NAME;;
		FolderUtil.createFolders(path);
		String csvFile = path + "COUPONS.csv";
		List<String[]> rows = CSVUtil.getInstanse().readCSV(csvFile);
		for (String[] row : rows) {
			String merchantName = row[0].trim();
			String title = row[1].trim();
			String code = row[2].trim();
			String startDate = row[3].trim();
			String endDate = row[4].trim();
			String url = row[5].trim();
		}		
	}
}
