package com.bm.coinmanagement.utility;

import com.bm.coinmanagement.coin.Coin;
import com.bm.coinmanagement.dao.CoinDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilities implements CoinDAO {
    static Scanner sc = new Scanner(System.in);

    @Override
    public void addCoin(List<Coin> coins) {

    }

    @Override
    public void updateCoin(List<Coin> coins) {

    }

    @Override
    public void deleteCoin(List<Coin> coins) {

    }

    @Override
    public List<Coin> getAllCoins(Connection connection) {

        List<Coin> coinList = new ArrayList<>();
        String sql = "SELECT * FROM coin_collection;";

        try {
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
                return coinList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showAllAvailableCoins(List<Coin> coins) {
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Coins in collection:");
        System.out.println("|------------------------------------------------------------------------------------------------|");
        System.out.println(String.format("| %-8s | %-15s | %-15s | %-12s | %-14s | %-15s |", "Coin_ID", "Country", "Denomination", "Year of Mint", "Current Value", "Acquired Date"));
        System.out.println("|------------------------------------------------------------------------------------------------|");


        for (Coin coin : coins) {
            System.out.println(coin);
//            System.out.println("ID: " + coin.getId() + ", Country: " + coin.getCountry() + ", Denomination: " + coin.getDenomination() + ", Year of Mint: " + coin.getYearOfMint() + ", Current Value: " + coin.getCurrentValue() + ", Acquired Date: " + coin.getAcquiredDate());

        }
        System.out.println("|________________________________________________________________________________________________|");
    }


    public int mainMenu() {

        int choice = -1; // Initialize with an invalid value
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("\n__________________________________________________________________________________________________________________________________________");
                System.out.println("1 ) : Show Available Collection\n" + "2 ) : Add Single Coin in collection\n" + "3 ) : Delete Single Coin from collection\n" + "4 ) : Update Single Coin in collection\n" + "5 ) : Add Multiple Coins in collection\n" + "6 ) : Add Coins in collection from CSV\n" + "7 ) : Save Current State in Database\n" + "0 ) : Exit by saving changes\n");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                if (choice >= 0 && choice <= 7) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 0 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next();
            }
        }

        return choice;
    }

}
