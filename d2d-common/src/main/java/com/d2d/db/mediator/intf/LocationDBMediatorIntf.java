package com.d2d.db.mediator.intf;

import com.d2d.service.common.beans.Location;

public interface LocationDBMediatorIntf {
    public Location create(Location location);

    public Location getLocationByIdx(long idx);

    public boolean delete(long idx);
}

