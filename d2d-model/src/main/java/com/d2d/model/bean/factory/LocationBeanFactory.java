package com.d2d.model.bean.factory;

import com.d2d.db.service.intf.LocationDBServiceIntf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LocationBeanFactory {
    private static ApplicationContext appContext = null;

    static {
        appContext = new ClassPathXmlApplicationContext(new String[]{"LocationCore.xml"});
    }

    public static LocationDBServiceIntf getLocationDBService() {
        return (LocationDBServiceIntf)appContext.getBean("locationDBService");
    }
}

