/*
 * Decompiled with CFR 0_101.
 */
package com.mail.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class MailProperties {
    private static Properties properties = new Properties();

    static {
        try {
            MailProperties util = new MailProperties();
            properties = util.getPropertiesFromClasspath("mail-config.properties");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MailProperties() {
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

