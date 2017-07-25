package com.d2d.model.util;

import com.d2d.model.beans.LocationModel;
import com.d2d.service.common.beans.Location;

public class LocationDBHelper {
    
	private static LocationDBHelper locationHelper;

    private LocationDBHelper() {
    }

    public static LocationDBHelper getInstance() {
        if (locationHelper == null) {
            locationHelper = new LocationDBHelper();
        }
        return locationHelper;
    }

    public Location getLocationByLocationModel(LocationModel locationModel) {
        Location location = null;
        if (locationModel != null) {
            location = new Location();
            location.setAddress(locationModel.getAddress());
            location.setArea(locationModel.getArea());
            location.setCity(locationModel.getCity());
            location.setCountry(locationModel.getCountry());
            location.setPincode(locationModel.getPincode());
            location.setState(locationModel.getState());
            location.setContactNo(locationModel.getContactNo());
            location.setIdx(locationModel.getIdx().longValue());
        }
        return location;
    }

    public LocationModel getLocationModelByLocation(Location location, boolean includeId) {
        LocationModel locationModel = null;
        if (location != null) {
            locationModel = new LocationModel();
            locationModel.setAddress(location.getAddress());
            locationModel.setArea(location.getArea());
            locationModel.setCity(location.getCity());
            //locationModel.setCountry(location.getCountry());
            locationModel.setPincode(location.getPincode());
            locationModel.setContactNo(location.getContactNo());
            //locationModel.setState(location.getState());
            locationModel.setCountry("NA");
            locationModel.setState("NA");
            if (includeId) {
                locationModel.setIdx(location.getIdx());
            }
        }
        return locationModel;
    }
}

