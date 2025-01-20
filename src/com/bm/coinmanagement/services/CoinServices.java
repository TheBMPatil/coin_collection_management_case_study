package com.bm.coinmanagement.services;

import com.bm.coinmanagement.coin.Coin;
import com.bm.coinmanagement.dbconnector.DbConnector;
import com.bm.coinmanagement.utility.Utilities;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CoinServices {
    public static void CoinManagement() {
        //Gather All resources
        List<Coin> coinList = new ArrayList<>();
        Utilities utils = new Utilities();
        try {
            //Establising connection With db
            Connection con = DbConnector.connectDB();
            coinList = utils.getAllCoins(con); // Read all coins from DB
            if (coinList != null) {
                while (true) {
                    switch (utils.mainMenu()) {
                        case 1 -> utils.showAllAvailableCoins(coinList);
                        case 2 -> System.out.println("Choice 2");
                        case 3 -> System.out.println("Choice 3");
                        case 4 -> System.out.println("Choice 4");
                        case 5 -> System.out.println("Choice 5");
                        case 6 -> System.out.println("Choice 6");
                        case 7 -> System.out.println("Choice 7");
                        case 0 -> {
                            System.out.println("Exit...");
                            return;
                        }

                    }

                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
