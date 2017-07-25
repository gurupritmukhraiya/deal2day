/**
 * 
 */
package com.d2d.service.seo.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author guruprit_mukhraiya
 *
 */
public class SEOObject {

	private static SEOObject seoObject = null;
    private static final Properties pro = new Properties();

    private SEOObject() {
        try {
            InputStream io = this.getClass().getResourceAsStream("/seo.properties");
            pro.load(io);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static SEOObject getInstance() {
        if (seoObject == null) {
            seoObject = new SEOObject();
        }
        return seoObject;
    }

    public String getProperty(String key) {
        return pro.getProperty(key);
    }
}
