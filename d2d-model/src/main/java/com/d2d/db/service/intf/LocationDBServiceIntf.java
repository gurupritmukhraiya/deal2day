package com.d2d.db.service.intf;

import com.d2d.db.exception.DBServiceException;
import com.d2d.model.beans.LocationModel;

public interface LocationDBServiceIntf {
    public void create(LocationModel var1) throws DBServiceException;

    public LocationModel getLocationByIdx(long var1) throws DBServiceException;

    public void delete(long var1) throws DBServiceException;
}

