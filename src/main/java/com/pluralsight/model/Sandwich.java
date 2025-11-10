package com.pluralsight.model;

import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Order{
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
    public void addMeat(String meat) {
        //   - add meat(s)
        meats.add(meat);
        //   - what is the price based on size and whether it's extra?
    }

    // addCheese method:
    public void addCheese(String cheese){
        //   - add cheese(s)
        cheeses.add(cheese);
        //   - add price depending on size and whether it's extra

    }

    // addTopping method:
    //   - add topping(s)
    //   - no charge

    // addSauce method:
    //   - add sauce(s)
    //   - no charge

    // getPrice method:
    //   - return current total price

    // getSummary method:
    //   - return a string with all sandwich details and price
}
