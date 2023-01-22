package com.bridgelabz;

import java.sql.*;

public class Jdbc_Main {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/payroll_service","root","Mysql^131");

            //executeUpdateQuery(conn,"Update Employee set salary=7000000 where name='Soujanya'");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("Select * from Employee where salary>7000000");


            displayResultSet(rs);

            // Close the connection
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void displayResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + " " + columnValue);
            }
            System.out.println("");
        }
    }

    public static void executeUpdateQuery(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(query);
        System.out.println(result + " rows affected by the update query");
    }

}
