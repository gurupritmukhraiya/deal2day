package com.d2d.model.bean.factory;

import com.d2d.db.service.intf.MerchantDBServiceIntf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MerchantBeanFactory {
    private static ApplicationContext appContext = null;

    static {
        appContext = new ClassPathXmlApplicationContext(new String[]{"MerchantCore.xml"});
    }

    public static MerchantDBServiceIntf getProviderDBService() {
        return (MerchantDBServiceIntf)appContext.getBean("merchantDBService");
    }
}

