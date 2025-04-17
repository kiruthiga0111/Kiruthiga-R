package com.petpals.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionUtil {

    // Return a new connection each time to avoid sharing one connection instance
    public static Connection getConnection() {
        // Get the properties object that contains the database details
        Properties properties = DbPropertiesUtil.getProperties();
        
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        // Check if any required properties are missing
        if (url == null || username == null || password == null) {
            System.out.println("Database connection details are missing in jdbc.properties file.");
            return null;
        }

        try {
            // Establish and return the database connection
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // Improved error logging for debugging
            System.err.println("Failed to establish a connection to the database.");
            e.printStackTrace();
        }

        return null;
    }
}
