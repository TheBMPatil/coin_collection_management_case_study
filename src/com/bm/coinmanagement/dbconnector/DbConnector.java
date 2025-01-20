package com.bm.coinmanagement.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    public static Connection connectDB() {
        String userName = "root";
        String password = "0787";
        String url = "jdbc:mysql://localhost:3308/coin_management";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("ACK : DB Connection Success..!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

}
