package com.pluralsight.model;

public class Drink extends Order{
    private String drinkSize;
    private String drinkFlavor;

    public Drink(String drinkSize, String drinkFlavor) {
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

}
