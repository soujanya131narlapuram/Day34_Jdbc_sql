package org.example;

import java.sql.*;

public class Jdbc_Main {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/payroll_service","root","Mysql^131");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("salary"));
            }

            // Close the connection
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
