package com.bm.coinmanagement.dao;

import com.bm.coinmanagement.coin.Coin;

import java.sql.Connection;
import java.util.List;

public interface CoinDAO {


    public abstract void addCoin(List<Coin> coins, List<Coin> originalCoins);

    public abstract void updateCoin(List<Coin> updateCoins, List<Coin> originalCoins);

    public abstract void deleteCoin(List<Coin> delCoins, List<Coin> originalCoins);

    public abstract List<Coin> getAllCoins(Connection con);

    public abstract boolean commitChanges(Connection con, List<Coin> insCoins, List<Coin> delCoins, List<Coin> updateCoins);
}
