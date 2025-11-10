package com.pluralsight.model;

import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    // store bread type (white, wheat, rye, wrap)
    private String breadType;
    // store sandwich size (4, 8, or 12 inches)
    private int breadSize;
    // store if sandwich is toasted
    private boolean isToasted;
    // store meats, cheeses, toppings, sauces
    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;
    // keep track of total price
    private double totalPrice;
    // constructor: takes bread type, size, toasted
    //   - initialize properties
    //   - set base price based on size

    public Sandwich(String breadType, int breadSize, boolean isToasted) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.isToasted = isToasted;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.totalPrice = getBasePrice(breadSize);
    }

    static double basePriceFourInch = 5.50;
    static double basePriceEightInch = 7.00;
    static double basePriceTwelveInch = 8.50;


    private double getBasePrice(int breadSize) {
        return switch (breadSize) {
            case 4 -> basePriceFourInch;
            case 8 -> basePriceEightInch;
            case 12 -> basePriceTwelveInch;
            default -> 0.00;
        };
    }

    // addMeat method:
    public void addMeat(String meatType, boolean isExtra) {
        //   - add meat(s)
        String meat;
        if (isExtra) {
            meat = meatType + " is (EXTRA)";
        } else {
            meat = meatType;
        }
        //   - what is the price based on size and whether it's extra?
        double meatPrice = switch (this.breadSize) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.00;
        };
        this.totalPrice += meatPrice;
        if (isExtra) {
            double extraMeatPrice = switch (this.breadSize) {
                case 4 -> 0.50;
                case 8 -> 1.00;
                case 12 -> 1.50;
                default -> 0.00;
            };
            this.totalPrice += extraMeatPrice;
        }
    }

    // addCheese method:
    public void addCheese(String cheeseType, boolean isExtra) {
        //   - add cheese(s)
        String cheese;
        if (isExtra) {
            cheese = cheeseType + " is (EXTRA)";
        } else {
            cheese = cheeseType;
        }
        //   - add price depending on size and whether it's extra
        double cheesePrice = switch (this.breadSize) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.00;
        };
        this.totalPrice += cheesePrice;
        if (isExtra) {
            double extraCheesePrice = switch (this.breadSize) {
                case 4 -> 0.30;
                case 8 -> 0.60;
                case 12 -> 0.90;
                default -> 0.00;
            };
            this.totalPrice += extraCheesePrice;
        }
    }

    // addTopping method:
    public void addTopping(String topping) {
        //   - add topping(s)
        //   - no charge
        this.toppings.add(topping);
    }

    // addSauce method:
    public void addSauce(String sauce) {
        //   - add sauce(s)
        //   - no charge
        this.sauces.add(sauce);
    }

    // getPrice method:
    public double getPrice() {
        //   - return current total price
        return this.totalPrice;
    }

    // getSummary method:
    //   - return a string with all sandwich details and price
    public String getSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("=========================================\n");
        sb.append("           SANDWICH SUMMARY\n");
        sb.append("=========================================\n");
        sb.append("breadType = '").append(breadType).append('\'');
        sb.append(", breadSize = ").append(breadSize);
        sb.append(", isToasted = ").append(isToasted);
        sb.append(", meats = ").append(meats);
        sb.append(", cheeses = ").append(cheeses);
        sb.append(", toppings = ").append(toppings);
        sb.append(", sauces = ").append(sauces);
        sb.append(", totalPrice = ").append(totalPrice);
        return sb.toString();
    }
}
