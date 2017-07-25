package com.d2d.service.category;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CategoryProperties {
    private static CategoryProperties categoryProperties = null;
    private Properties properties = new Properties();

    private CategoryProperties() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("category.properties");
            this.properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized CategoryProperties getInstance() {
        if (categoryProperties == null) {
            categoryProperties = new CategoryProperties();
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

