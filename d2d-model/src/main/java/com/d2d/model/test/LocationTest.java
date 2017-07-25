package com.d2d.model.test;

import com.d2d.db.mediator.impl.LocationDBMediatorImpl;
import com.d2d.service.common.beans.Location;

public class LocationTest {
    private LocationDBMediatorImpl locationDBMediatorImpl = new LocationDBMediatorImpl();

    public static void main(String[] args) {
        LocationTest test = new LocationTest();
        test.addLocation();
    }

    public void deleteLocation() {
        this.locationDBMediatorImpl.delete(1);
    }

    public void addLocation() {
        Location location = new Location();
        location.setCountry("India");
        location.setState("Maharashtra");
        location.setCity("Pune");
        location.setArea("Baner");
        location.setAddress("Palladion");
        location.setContactNo("9890738221");
        location.setPincode("411004");
        location.setMerchantId(1);
        this.locationDBMediatorImpl.create(location);
    }
}

