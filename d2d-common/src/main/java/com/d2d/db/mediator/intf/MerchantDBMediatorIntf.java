package com.d2d.db.mediator.intf;

import java.util.List;

import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;

public interface MerchantDBMediatorIntf {
	
    public Merchant create(Merchant var1);

    public boolean isMerchantExist(String var1);

    public Merchant getMerchantWithAddressAndOffer(String var1);

    public Merchant getMerchantByMerchantId(String var1);

    public boolean update(Merchant var1);

	public List<Merchant> getAllMerchants();

	public Merchant getMerchantByIdx(long idx);

	public boolean updateMerchantStatus(long id, String status);

	public boolean updateMerchantName(long id, long merchantId);

	public boolean isMerchantNameExist(String name);

	public MerchantName createMerchantName(MerchantName merchantName);

	public List<MerchantName> getAllMerchantNames();
	
	public List<MerchantName> getMerchants();
		
}

