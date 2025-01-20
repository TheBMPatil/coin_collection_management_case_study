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
        this.id = id;
        this.country = country;
        this.denomination = denomination;
        this.yearOfMint = yearOfMint;
        this.currentValue = currentValue;
        this.acquiredDate = acquiredDate;
    }

    public Coin(double denomination, String country, int yearOfMint, double currentValue, LocalDate acquiredDate) {
        this.country = country;
        this.denomination = denomination;
        this.yearOfMint = yearOfMint;
        this.currentValue = currentValue;
        this.acquiredDate = acquiredDate;
    }

    // Copy constructor
    public Coin(Coin other) {
        this.id = other.getId();
        this.country = other.getCountry();
        this.denomination = other.getDenomination();
        this.yearOfMint = other.getYearOfMint();
        this.currentValue = other.getCurrentValue();
        this.acquiredDate = other.getAcquiredDate();
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

    @Override
    public String toString() {
//        return "Coin{" + "id=" + id + ", country='" + country + '\'' + ", denomination=" + denomination + ", yearOfMint=" + yearOfMint + ", currentValue=" + currentValue + ", acquiredDate=" + acquiredDate + '}';
//        return "| Coin_ID: " + this.getId() + ", Country: " + this.getCountry() + ", Denomination: " + this.getDenomination() + ", Year of Mint: " + this.getYearOfMint() + ", Current Value: " + this.getCurrentValue() + ", Acquired Date: " + this.getAcquiredDate()+ " \t| ";
        return String.format(
                "| %-8s | %-15s | %-15s | %-12s | %-14s | %-15s |",
                getId(),                // Coin_ID
                getCountry(),           // Country
                getDenomination(),      // Denomination
                getYearOfMint(),        // Year of Mint
                getCurrentValue(),      // Current Value
                getAcquiredDate()       // Acquired Date
        );
    }


}
