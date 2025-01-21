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
        List<Coin> updateCoinList = new ArrayList<>();
        List<Coin> delCoinList = new ArrayList<>();
        List<Coin> insCoinList = new ArrayList<>();
        Utilities utils = new Utilities();
        try {
            //Establising connection With db
            Connection con = DbConnector.connectDB();
            coinList = utils.getAllCoins(con); // Read all coins from DB
            if (coinList != null) {
                while (true) {
                    switch (utils.mainMenu()) {
                        case 1 -> utils.showAllAvailableCoins(coinList);
                        case 2 -> {
                            utils.showAllAvailableCoins(coinList);
                            utils.addCoin(insCoinList, coinList);
                            System.out.println("Newly added : ");
                            utils.showAllAvailableCoins(insCoinList);
                        }
                        case 3 -> {
                            utils.showAllAvailableCoins(coinList);
                            utils.deleteCoin(delCoinList, coinList);
                            System.out.println("Deleted : ");
                            utils.showAllAvailableCoins(delCoinList);

                        }

                        case 4 -> {
                            utils.showAllAvailableCoins(coinList);
                            utils.updateCoin(updateCoinList, coinList);
                            System.out.println("Updated : ");
                            utils.showAllAvailableCoins(updateCoinList);
                        }

                        case 5 -> {
                            utils.showAllAvailableCoins(coinList);

                            System.out.println("How many coins do you want to add : ");
                            int noOfCoins = Utilities.sc.nextInt();
                            for (int i = 1; i <= noOfCoins; i++) {
                                utils.addCoin(insCoinList, coinList);
                            }
                            System.out.println("Newly added : ");
                            utils.showAllAvailableCoins(insCoinList);
                        }
                        case 6 -> System.out.println("Not yet possible..! Coming soon??");

                        case 7 -> {
                            if (utils.commitChanges(con, insCoinList, delCoinList, updateCoinList)) {
                                System.out.println("Commited changes successfully");
                                insCoinList.clear();
                                delCoinList.clear();
                                updateCoinList.clear();
                                coinList.clear();
                                coinList = utils.getAllCoins(con);
                            } else System.out.println("Unable to complete operation");
                        }
                        case 8 -> utils.searchSort(coinList);
                        case 0 -> {
                            if (utils.commitChanges(con, insCoinList, delCoinList, updateCoinList)) {
                                System.out.println("Commited changes successfully");
                            } else System.out.println("Unable to complete operation");
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
