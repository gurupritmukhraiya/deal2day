package com.d2d.model.bean.factory;

import com.d2d.db.service.intf.OfferDBServiceIntf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfferBeanFactory {
    private static ApplicationContext appContext = null;

    static {
        appContext = new ClassPathXmlApplicationContext("OfferCore.xml");
    }

    public static OfferDBServiceIntf getOfferDBService() {
        return (OfferDBServiceIntf)appContext.getBean("offerDBService");
    }
}

