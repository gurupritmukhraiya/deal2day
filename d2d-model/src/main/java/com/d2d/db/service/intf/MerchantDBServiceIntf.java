package com.d2d.db.service.intf;

import java.util.List;

import com.d2d.db.exception.DBServiceException;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.MerchantNameModel;
import com.d2d.model.beans.MerchantProfile;

public interface MerchantDBServiceIntf {
	
    public void create(MerchantLogin var1) throws DBServiceException;

    public MerchantLogin getMerchantById(long var1, boolean var3, boolean var4) throws DBServiceException;

    public MerchantLogin getMerchantByLoginId(String var1, boolean var2, boolean var3) throws DBServiceException;

    public void update(MerchantLogin var1) throws DBServiceException;
 
	public List<MerchantLogin> getAllMerchants() throws DBServiceException;

	public List<MerchantNameModel> getAllMerchantNames() throws DBServiceException;

	public void createMerchantName(MerchantNameModel merchantName)	throws DBServiceException;

	public MerchantNameModel getMerchantByName(String name) throws DBServiceException;

	public void updateMerchantName(long var1, long var2) throws DBServiceException;
	
	public List<MerchantProfile> getMerchants() throws DBServiceException;
	
	public boolean isMerchantNameExist(String merchantName) throws DBServiceException;
}

