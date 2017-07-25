package com.d2d.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConstantProperties {
   
	private static ConstantProperties categoryProperties = null;
    private Properties properties = new Properties();

    private ConstantProperties() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(System.getProperty("currentEnv") + "-constants.properties");
            this.properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConstantProperties getInstance() {
        if (categoryProperties == null) {
            categoryProperties = new ConstantProperties();
        }
        return categoryProperties;
    }

    public String getValue(String key) {
        String value = null;
        if (this.properties.containsKey(key)) {
            value = (String)this.properties.get(key);
        } else {
            System.out.println("########------- Property Key : " + key + " not exists ");
        }
        return value;
    }
}

