package com.pluralsight.model;

public class Drink {
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

    public double getPrice() {
        return switch (drinkSize.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.00;
        };
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Drink{");
        sb.append("drinkSize='").append(drinkSize).append('\'');
        sb.append(", drinkFlavor='").append(drinkFlavor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
