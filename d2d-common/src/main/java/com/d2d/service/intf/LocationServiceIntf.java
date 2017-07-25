package com.d2d.service.intf;

import com.d2d.service.common.beans.Location;
import com.d2d.service.util.Response;

public interface LocationServiceIntf {
	
    public abstract Location createLocation(Location location);

    public abstract Response deleteLocation(long locationId);

	public abstract Location getLocation(long locationId);
}

