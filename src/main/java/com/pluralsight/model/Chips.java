package com.pluralsight.model;

public class Chips extends Order{
    private String chipsType;

    public Chips(String chipsType) {
        this.chipsType = chipsType;
    }

    public String getChipsType() {
        return chipsType;
    }

    public double getPrice() {
        return 1.50;
    }
}
