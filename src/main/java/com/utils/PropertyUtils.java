package com.utils;

import com.config.configReader;

public class PropertyUtils {

    // Returns configuration value
    public static String getProperty(String key) {
        return configReader.get(key);
    }
}
