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
//        if (drinkSize.toLowerCase().equals("small")) {
//            return 2.00;
//        } else if (drinkSize.toLowerCase().equals("medium")) {
//            return 2.50;
//        } else {
//            return 3.00;
//        }
        return switch (drinkSize.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.00;
        };
    }
}
