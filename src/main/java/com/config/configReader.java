package com.config;

import java.io.FileInputStream;

import java.util.Properties;

public class configReader {

    private static Properties properties;

    // Load configuration file once
    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config.properties");

            properties = new Properties();
            properties.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns value based on key
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
