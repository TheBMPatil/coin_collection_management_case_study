package com.bm.coinmanagement.dbconnector;

import com.bm.coinmanagement.coin.Coin;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbConnector {

    public static Connection connectDB() {
        String userName = "root";
        String password = "0787";
        String url = "jdbc:mysql://localhost:3308/coin_management";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection Success..!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM coin_collection;";
        List<Coin> coinList = new ArrayList<>();

        try (Connection connection = connectDB()) {
            if (connection != null) {
                Statement st = connection.createStatement();
                ResultSet res = st.executeQuery(sql);

                // Map ResultSet to Coin objects and store in ArrayList
                while (res.next()) {
                    int id = res.getInt("id");
                    String country = res.getString("country");
                    double denomination = res.getDouble("denomination");
                    int yearOfMint = res.getInt("year_of_mint");
                    double currentValue = res.getDouble("current_value");
                    LocalDate acquiredDate = res.getDate("acquired_date").toLocalDate();

                    // Create Coin object
                    Coin coin = new Coin(denomination, id, country, yearOfMint, currentValue, acquiredDate);

                    // Add to the list
                    coinList.add(coin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Display the coins
        System.out.println("Coins in collection:");
        for (Coin coin : coinList) {
            System.out.println("ID: " + coin.getId() + ", Country: " + coin.getCountry() + ", Denomination: " + coin.getDenomination() + ", Year of Mint: " + coin.getYearOfMint() + ", Current Value: " + coin.getCurrentValue() + ", Acquired Date: " + coin.getAcquiredDate());
        }
    }
}
