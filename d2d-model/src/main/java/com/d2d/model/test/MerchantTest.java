package com.d2d.model.test;

import java.util.Date;
import java.util.List;

import com.d2d.db.mediator.impl.MerchantDBMediatorImpl;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;

public class MerchantTest{
	
	private MerchantDBMediatorImpl merchantDBMediatorImpl;
	
	public MerchantTest(String currEnv) {
		System.setProperty("currentEnv", currEnv);
		merchantDBMediatorImpl = new MerchantDBMediatorImpl();
	}
		
	public static void main(String[] args) {
        MerchantTest test = new MerchantTest("dev");
        test.createMerchant();
    }	

    public void createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setContactNo("9893182455");
        merchant.setCreatedDate(new Date());
        merchant.setEmailId("admin@deal2day.in");
        merchant.setMerchantName("DEAL2DAY");
        merchant.setPassword("this4now");
        merchant.setRole("ADMIN_ROLE");
        merchant.setStatus("A");
        Merchant merchantFromDB = this.merchantDBMediatorImpl.create(merchant);       
    }

    public void getMerchant() {
        //Merchant merchant = this.merchantDBMediatorImpl.getMerchantByMerchantId("guru@gmail.com");
        //System.out.println("Merchant Updated succfully" + merchant.getEmailId());
    	
    	List<MerchantName> m1 = this.merchantDBMediatorImpl.getMerchants();
    	System.out.println(m1.get(0).getMerchantName());
    	
    }

    public void updateMerchant() {
        Merchant merchant = new Merchant();
        merchant.setContactNo("9893100000");
        merchant.setIdx(1);
        this.merchantDBMediatorImpl.update(merchant);
        System.out.println("Merchant Updated succfully");
    }

    public void updatePassword() {
        Merchant merchant = new Merchant();
        merchant.setPassword("this4now");
        merchant.setOldPassword("this4person");
        merchant.setIdx(1);
        this.merchantDBMediatorImpl.update(merchant);
        System.out.println("Merchant Updated succfully");
    }

    public void changeStatus() {
        Merchant merchant = new Merchant();
        merchant.setStatus("Inactive");
        merchant.setIdx(1);
        this.merchantDBMediatorImpl.update(merchant);
        System.out.println("Merchant Updated succfully");
    }
}

