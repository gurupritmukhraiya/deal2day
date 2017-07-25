package com.d2d.cache;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.d2d.db.mediator.intf.MerchantDBMediatorIntf;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;
import com.d2d.service.locator.ServiceLocator;

public class MerchantNameCache {
	
	private MerchantDBMediatorIntf merchantDBMediator = ServiceLocator.getServiceLocator().getMerchantDBService();
	
    private static Map<String, Long> merchantNameMap;
    private static List<MerchantName> merchantNameWithoutId;
    private static MerchantNameCache merchantCache;
    
    public static void reloadCache(){
    	merchantNameMap = null;
    	merchantNameWithoutId = null;
    	merchantCache = null;
    	getInstanse();
    }

    private MerchantNameCache() {
    	//From MerchantName
    	List<MerchantName> merchantNames = merchantDBMediator.getAllMerchantNames();
    	for (MerchantName merchantName : merchantNames) {
    		if(merchantName != null && merchantName.getMerchantId() != -1){
    			addMerchantName(merchantName.getMerchantName(), merchantName.getMerchantId());
    		}else{
    			addMerchantNameWithoutId(merchantName);
    		}
		}
    	
    	//From Merchant Login
    	List<Merchant> merchants = merchantDBMediator.getAllMerchants();
    	for (Merchant merchant : merchants) {
			addMerchantName(merchant.getMerchantName(), merchant.getIdx());
		}
    }

	public static MerchantNameCache getInstanse() {
		if (merchantNameMap == null) {
        	merchantNameMap = new ConcurrentHashMap<String, Long>();
        }
        if(merchantNameWithoutId == null){
        	merchantNameWithoutId = new LinkedList<MerchantName>();
        }
        if (merchantCache == null) {
        	merchantCache = new MerchantNameCache();
        }
        return merchantCache;
    }
	
    public void addMerchantName(String name, Long merchantId) {
		merchantNameMap.put(name, merchantId);
	}
    
    public void updateMerchantId(String name, Long merchantId) {
		merchantNameMap.put(name, merchantId);
	}
    
    public Long getMerchantId(String name) {
		return merchantNameMap.get(name);
	}
    
    public boolean isMerchantNameExist(String name) {
		return merchantNameMap.containsKey(name);
	}
    
    public Map<String, Long> getAllMerchantNameAndId() {
		return merchantNameMap;
	}
    
    public void removeMerchantName(String name){
    	merchantNameMap.remove(name);
    }
    
    public void addMerchantNameWithoutId(MerchantName merchantName){
    	merchantNameWithoutId.add(merchantName);
    }
    
    public void assignIdToMerchantName(MerchantName merchantNameObj) {
		merchantNameWithoutId.remove(merchantNameObj);
		merchantNameMap.put(merchantNameObj.getMerchantName(), merchantNameObj.getMerchantId());
	}
    
    public List<MerchantName> getMerchantNamesWithoutId() {
		return merchantNameWithoutId;
	}
    
    public static void main(String[] args) {
		
	}
}
