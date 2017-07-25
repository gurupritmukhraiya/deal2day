package com.d2d.service.intf;

import java.util.List;

import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;
import com.d2d.service.util.Response;

public interface MerchantServiceIntf {
	
    public Response registerMerchant(Merchant var1);

    public Response verifyMerchant(String var1, String var2);

    public Merchant getMerchantWithAddressAndOffer(String var1);

    public Response updateMerchant(Merchant var1);

	public List<Merchant> getAllMerchants();
	
	public Merchant getMerchantByMerchantID(long idx);

	public Response updateMerchantStatus(long id, String status);

	public Response addMerchant(Merchant merchant);

	public Response addMerchantName(MerchantName merchantName);

	public Response updateMerchantName(MerchantName merchant);
	
	public List<MerchantName> getAllMerchantNames();
	
}

