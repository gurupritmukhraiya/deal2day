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

public class ServiceLocatorImpl implements ServiceLocatorIntf {
	
    @Override
    public MerchantServiceIntf getMerchantService() {
        return (MerchantServiceIntf)ServiceLocator.getServiceContext().getBean("merchantService");
    }

    @Override
    public MerchantDBMediatorIntf getMerchantDBService() {
        return (MerchantDBMediatorIntf)ServiceLocator.getServiceContext().getBean("merchantDBService");
    }

    @Override
    public OfferServiceIntf getOfferService() {
        return (OfferServiceIntf)ServiceLocator.getServiceContext().getBean("offerService");
    }

    @Override
    public OfferDBMediatorIntf getOfferDBService() {
        return (OfferDBMediatorIntf)ServiceLocator.getServiceContext().getBean("offerDBService");
    }

    @Override
    public OfferDatafileMediatorIntf getOfferDatafileService() {
        return (OfferDatafileMediatorIntf)ServiceLocator.getServiceContext().getBean("offerDFService");
    }

    @Override
    public LocationServiceIntf getLocationService() {
        return (LocationServiceIntf)ServiceLocator.getServiceContext().getBean("locationService");
    }

    @Override
    public LocationDBMediatorIntf getLocationDBServiceIntf() {
        return (LocationDBMediatorIntf)ServiceLocator.getServiceContext().getBean("locationDBService");
    }

	@Override
	public CouponServiceIntf getCouponService() {
        return (CouponServiceIntf)ServiceLocator.getServiceContext().getBean("couponService");
	}

	@Override
	public CouponDBMediatorIntf getCouponDBService() {
        return (CouponDBMediatorIntf)ServiceLocator.getServiceContext().getBean("couponDBService");
	}
}

