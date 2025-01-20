package com.bm.coinmanagement.dao;

import com.bm.coinmanagement.coin.Coin;

import java.sql.Connection;
import java.util.List;

public interface CoinDAO {


    public abstract void addCoin(List<Coin> coins);

    public abstract void updateCoin(List<Coin> coins);

    public abstract void deleteCoin(List<Coin> coins);

    public abstract List<Coin> getAllCoins(Connection con);

}
