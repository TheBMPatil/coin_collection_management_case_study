package com.bm.coinmanagement.coin;

import java.time.LocalDate;

public final class Coin {
    private int id;
    private String country;
    private double denomination;
    private int yearOfMint;
    private double currentValue;
    private LocalDate acquiredDate;


    public Coin(double denomination, int id, String country, int yearOfMint, double currentValue, LocalDate acquiredDate) {
        this.denomination = denomination;
        this.id = id;
        this.country = country;
        this.yearOfMint = yearOfMint;
        this.currentValue = currentValue;
        this.acquiredDate = acquiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getDenomination() {
        return denomination;
    }

    public void setDenomination(double denomination) {
        this.denomination = denomination;
    }

    public int getYearOfMint() {
        return yearOfMint;
    }

    public void setYearOfMint(int yearOfMint) {
        this.yearOfMint = yearOfMint;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDate acquiredDate) {
        this.acquiredDate = acquiredDate;
    }
}
