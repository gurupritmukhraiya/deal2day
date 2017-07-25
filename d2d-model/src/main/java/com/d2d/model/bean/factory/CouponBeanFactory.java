package com.d2d.model.bean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.d2d.db.service.intf.CouponDBServiceIntf;

public class CouponBeanFactory {
	
    private static ApplicationContext appContext = null;

    static {
        appContext = new ClassPathXmlApplicationContext(new String[]{"CouponCore.xml"});
    }

    public static CouponDBServiceIntf getCouponDBService() {
        return (CouponDBServiceIntf)appContext.getBean("couponDBService");
    }
}

