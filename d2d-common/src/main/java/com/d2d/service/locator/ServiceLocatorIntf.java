package com.d2d.service.locator;

import com.d2d.datafile.mediator.intf.OfferDatafileMediatorIntf;
import com.d2d.db.mediator.intf.CouponDBMediatorIntf;
import com.d2d.db.mediator.intf.LocationDBMediatorIntf;
import com.d2d.db.mediator.intf.MerchantDBMediatorIntf;
import com.d2d.db.mediator.intf.OfferDBMediatorIntf;
import com.d2d.service.intf.CouponServiceIntf;
import com.d2d.service.intf.LocationServiceIntf;
import com.d2d.service.intf.MerchantServiceIntf;
import com.d2d.service.intf.OfferServiceIntf;

public interface ServiceLocatorIntf {
    public MerchantServiceIntf getMerchantService();

    public MerchantDBMediatorIntf getMerchantDBService();

    public LocationServiceIntf getLocationService();

    public LocationDBMediatorIntf getLocationDBServiceIntf();

    public OfferServiceIntf getOfferService();

    public OfferDBMediatorIntf getOfferDBService();

    public OfferDatafileMediatorIntf getOfferDatafileService();
    
    public CouponServiceIntf getCouponService();
    
    public CouponDBMediatorIntf getCouponDBService();
}

