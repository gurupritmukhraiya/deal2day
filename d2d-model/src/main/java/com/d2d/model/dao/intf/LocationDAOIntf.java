package com.d2d.model.dao.intf;

import com.d2d.db.exception.DBServiceException;
import com.d2d.model.beans.LocationModel;

public interface LocationDAOIntf {
    public void create(LocationModel var1) throws DBServiceException;

    public LocationModel getLocationByIdx(long var1) throws DBServiceException;

    public void delete(long var1) throws DBServiceException;
}

