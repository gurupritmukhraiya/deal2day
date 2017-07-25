package com.d2d.service;

import com.d2d.db.mediator.intf.LocationDBMediatorIntf;
import com.d2d.service.common.beans.Location;
import com.d2d.service.intf.LocationServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.Response;

public class LocationService implements LocationServiceIntf {
	
    private LocationDBMediatorIntf locationDBMediator = ServiceLocator.getServiceLocator().getLocationDBServiceIntf();

    @Override
    public Location createLocation(Location location) {
        Location locationNew = locationDBMediator.create(location);
        return locationNew;
    }
    
    @Override
    public Location getLocation(long locationId) {
        return locationDBMediator.getLocationByIdx(locationId);
    }

    @Override
    public Response deleteLocation(long idx) {
        boolean isDeleted = this.locationDBMediator.delete(idx);
        if (isDeleted) {
            return new Response("success", "Location removed");
        }
        return new Response("fail", "Location can not remove yet");
    }
}

