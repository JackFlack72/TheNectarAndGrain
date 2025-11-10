package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // create List for order items (sandwiches, drinks, and chips)
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    // store total price
    private double totalOrderPrice;

    // constructor:

    public Order() {
        //   - initialize the class propeties
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
//        this.totalOrderPrice = 0.00;
    }


    // addSandwich method:
    public void addSandwich(Sandwich sandwich) {
        //   - add sandwich to list
        sandwiches.add(sandwich);
    }

    // addDrink method:
    public void addDrink(Drink drink) {
        //   - add drink to list
        drinks.add(drink);
    }

    // addChips method:
    public void addChips(Chips chip) {
        //   - add chips to list
        chips.add(chip);
    }

    // getTotal method:
    public double getTotal() {
        //   - return total price of order
        double total = 0.00;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    // getSandwiches, getDrinks, getChips:
    //   - return the orders items
    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    // getOrderSummary method:
    //   - return formatted string of all items and total
    // AI generated method
    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================\n");
        sb.append("         ORDER SUMMARY\n");
        sb.append("=========================================\n");

        if (!sandwiches.isEmpty()) {
            sb.append("\n[SANDWICHES]\n");
            for (Sandwich s : sandwiches) {
                sb.append("-----------------------------------------\n");
                sb.append(s.getSummary());
            }
        }

        if (!drinks.isEmpty()) {
            sb.append("\n[DRINKS]\n");
            for (Drink d : drinks) {
                sb.append("  - ").append(d).append("\n");
            }
        }

        if (!chips.isEmpty()) {
            sb.append("\n[CHIPS]\n");
            for (Chips c : chips) {
                sb.append("  - ").append(c).append("\n");
            }
        }

        sb.append("\n=========================================\n");
        sb.append(String.format("TOTAL ITEMS: %d\n", sandwiches.size() + drinks.size() + chips.size()));
        sb.append(String.format("FINAL ORDER TOTAL: $%.2f\n", getTotal()));
        sb.append("=========================================\n");

        return sb.toString();
    }
}
