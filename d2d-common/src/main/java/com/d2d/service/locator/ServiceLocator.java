package com.d2d.service.locator;

import com.d2d.service.locator.ServiceLocatorImpl;
import com.d2d.service.locator.ServiceLocatorIntf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocator {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("service-beans.xml");
    private static ServiceLocatorIntf serviceLocator;

    public static ServiceLocatorIntf getServiceLocator() {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocatorImpl();
        }
        return serviceLocator;
    }

    public static ApplicationContext getServiceContext() {
        return context;
    }
}

