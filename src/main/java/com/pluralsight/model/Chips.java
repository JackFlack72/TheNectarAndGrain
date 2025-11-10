package com.pluralsight.model;

public class Chips {
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
