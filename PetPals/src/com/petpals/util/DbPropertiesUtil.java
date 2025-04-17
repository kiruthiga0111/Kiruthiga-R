package com.petpals.util;


import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class DbPropertiesUtil {

    public static Properties getProperties() {
        Properties properties = new Properties();
        // Use the correct class name to get the resource
        InputStream inputStream = DbPropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

        if (inputStream == null) {
            System.out.println("Property file 'jdbc.properties' not found in the classpath.");
            return properties;
        }

        try {
            // Load the properties from the input stream
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }
}
