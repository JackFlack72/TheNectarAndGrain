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

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("CHIPS = ");
        sb.append("Type of Chips: '").append(chipsType).append('\'');
        return sb.toString();
    }
}
