package com.d2d.db.service.impl;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.service.intf.LocationDBServiceIntf;
import com.d2d.model.beans.LocationModel;
import com.d2d.model.dao.intf.LocationDAOIntf;

public class LocationDBServiceImpl implements LocationDBServiceIntf {
	
    private LocationDAOIntf locationDAOIntf;

    public LocationDAOIntf getLocationDAOIntf() {
        return this.locationDAOIntf;
    }
    public void setLocationDAOIntf(LocationDAOIntf locationDAOIntf) {
        this.locationDAOIntf = locationDAOIntf;
    }

    @Override
    public void create(LocationModel locationModel) throws DBServiceException {
        try {
            this.getLocationDAOIntf().create(locationModel);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public LocationModel getLocationByIdx(long idx) throws DBServiceException {
        try {
            return this.getLocationDAOIntf().getLocationByIdx(idx);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }

    @Override
    public void delete(long idx) throws DBServiceException {
        try {
            this.getLocationDAOIntf().delete(idx);
        }
        catch (Exception ex) {
            throw new DBServiceException(ex);
        }
    }
}

