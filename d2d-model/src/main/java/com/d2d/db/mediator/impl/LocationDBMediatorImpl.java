package com.d2d.db.mediator.impl;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.mediator.intf.LocationDBMediatorIntf;
import com.d2d.db.service.intf.LocationDBServiceIntf;
import com.d2d.model.bean.factory.LocationBeanFactory;
import com.d2d.model.beans.LocationModel;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.util.LocationDBHelper;
import com.d2d.service.common.beans.Location;

public class LocationDBMediatorImpl
implements LocationDBMediatorIntf {
    LocationDBServiceIntf locationDBService = LocationBeanFactory.getLocationDBService();
    LocationDBHelper locationDBHelper = LocationDBHelper.getInstance();

    public Location create(Location location) {
        LocationModel locationModel = this.locationDBHelper.getLocationModelByLocation(location, false);
        try {
            MerchantLogin merchantLogin = new MerchantLogin();
            merchantLogin.setIdx(location.getMerchantId());
            locationModel.setMerchant(merchantLogin);
            this.locationDBService.create(locationModel);
            if (locationModel.getIdx() != 0) {
                location.setIdx(locationModel.getIdx().longValue());
                return location;
            }
        }
        catch (DBServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Location getLocationByIdx(long idx){
    	Location location = null;
		try {
			LocationModel locationModel = this.locationDBService.getLocationByIdx(idx);
			location = this.locationDBHelper.getLocationByLocationModel(locationModel);
		} catch (DBServiceException e) {
			e.printStackTrace();
		}        
        return location;
    }

    public boolean delete(long idx) {
        try {
            this.locationDBService.delete(idx);
            return true;
        }
        catch (DBServiceException e) {
            e.printStackTrace();
            return false;
        }
    }
}

