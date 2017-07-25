/*
 * Decompiled with CFR 0_101.
 */
package com.sms.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class SMSProperties {
    private static Properties properties = new Properties();

    static {
        try {
            SMSProperties util = new SMSProperties();
            properties = util.getPropertiesFromClasspath("sms-config.properties");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SMSProperties() {
    }

    private Properties getPropertiesFromClasspath(String propFileName) throws IOException {
        Properties props = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        props.load(inputStream);
        return props;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Set<Object> getkeys() {
        return properties.keySet();
    }
}

