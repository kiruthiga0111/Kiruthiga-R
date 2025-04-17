
package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/trainingdb";
        String username = "root";
        String password = "kiru@2003";

        String sql = "CREATE TABLE staff (staff_name VARCHAR(20), staff_id INT PRIMARY KEY, department VARCHAR(20))";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.prepareStatement(sql);
            boolean result = statement.execute();
            System.out.println("Table created: " + !result);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
