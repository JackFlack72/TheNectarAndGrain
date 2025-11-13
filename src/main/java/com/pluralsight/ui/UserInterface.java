package com.pluralsight.ui;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    // declare a Scanner object for reading input from the console
    private Order order;
    private Scanner scanner = new Scanner(System.in);

    // constructor:


    public void display() {
        boolean runningDisplay = true;
        while (runningDisplay) {
            String displayChoice = showHomeScreen();
            switch (displayChoice) {
                case "1":
                    startNewOrder();
                    break;
                case "0":
                    System.out.println("Thank you for trying The Nectar and Grain! Please come again soon!");
                    runningDisplay = false;
                    break;
                default:
                    System.out.println("Invalid choice entered. Please try again.");

            }
        }
    }

    private void startNewOrder() {
        order = new Order();
        showOrderMenu();
    }

    // showHomeScreen:
    public String showHomeScreen() {
        //   - print app title and welcome message
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   Welcome to The Nectar and Grain!   ║");
        System.out.println("╚════════════════════════════════════╝");        //   - print:
        //       1) New Order
        System.out.println("1) New Order");
        //       0) Exit
        System.out.println("0) Exit");
        //   - prompt user for choice
        System.out.println("Enter your choice: ");
        //   - return user input
        return getUserInput();
    }

    // showOrderMenu:
    private void showOrderMenu() {
        boolean runningOrderMenu = true;
        while (runningOrderMenu) {
            //   - print:
            System.out.println("\n--- Menu ---");
            //       1) Add Sandwich
            System.out.println("1) Add Sandwich");
            //       2) Add Drink
            System.out.println("2) Add Drink");
            //       3) Add Chips
            System.out.println("3) Add Chips");
            //       4) Checkout
            System.out.println("4) Checkout");
            //       0) Cancel Order
            System.out.println("0) Cancel Order");
            //   - prompt user for choice
            System.out.println("\nEnter your choice: ");
            //   - return user input
            String orderChoice = getUserInput();

            switch (orderChoice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkoutOrder();
                    runningOrderMenu = false;
                    break;
                case "0":
                    runningOrderMenu = false;
                    System.out.println("The order has been cancelled.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try entering a choice again.");
            }
        }
    }

    // promptForBreadType:
    private String promptForBreadType() {
        //   - print list of bread types
        System.out.println("\nBread: Zeus' Cloud (white), Demeter's Harvest (wheat), Poseidon's Seaweed (rye), Cyclop's Eye (wrap)");
        //   - ask user to type one in (e.g., "white")
        System.out.println("Bread choice(enter the translated item in parens): ");
        //   - return as user input
        return scanner.nextLine();
    }

    // promptForSize:
    private String promptForSize() {
        //   - ask user: "What size? (4, 8, or 12 inches)"
        System.out.println("\nSandwich size (4, 8, 12 inches: ");
        //   - return user input
        return getUserInput();
    }

    // promptForToasted:
    private String promptForToasted() {
        //   - ask: "Would you like it toasted? (yes or no)"
        System.out.println("\nWould you like your sandwich toasted (yes/no): ");
        //   - return user input
        return getUserInput();
    }

    // promptForMeats:
    private void promptForMeats(Sandwich sandwich) {
        System.out.println("\nMeats: Minotaur's Might (steak), Ares' Rage (ham), Medusa's Serpent (salami), Hercules' Strength (roast beef), Apollo's Feather (chicken), Bacchus' Delight (bacon)");
        System.out.println("(Enter: the translated name in parens, 'extra' to add extra meat, 'done' when finished adding meats): ");
        boolean runningMeat = true;
        while (runningMeat) {
            String meats = scanner.nextLine();

            if (meats.equalsIgnoreCase("done")) {
                break;
            } else if (!meats.isEmpty()) {
                System.out.println("Would you like to add extra " + meats + "(yes/no): ");
                String extraMeatChoice = scanner.nextLine();
                boolean isExtraMeat = extraMeatChoice.equalsIgnoreCase("yes");
                sandwich.addMeat(meats, isExtraMeat);
                System.out.println("You added extra" + meats);
            }
        }
    }

    private void promptForCheeses(Sandwich sandwich) {
        System.out.println("\nCheeses: Athena's Wisdom (american), Prometheus' Fire (provolone), Chimera's Kiss (cheddar), Sphinx's Secret (swiss)");
        System.out.println("(Enter: the translated name in parens, 'extra' to add extra cheese and 'done' when finished adding cheeses): ");
        boolean runningCheese = true;
        while (runningCheese) {
            String cheeses = scanner.nextLine();

            if (cheeses.equalsIgnoreCase("done")) {
                break;
            } else if (!cheeses.isEmpty()) {
                System.out.println("Would you like to add extra " + cheeses + "(yes/no): ");
                String extraCheeseChoice = scanner.nextLine();
                boolean isExtraCheese = extraCheeseChoice.equalsIgnoreCase("yes");
                sandwich.addCheese(cheeses, isExtraCheese);
                System.out.println("You added extra" + cheeses);
            }
        }
    }

    private void promptForToppings(Sandwich sandwich) {
        System.out.println("\nToppings: Dryad's Leaf (lettuce), Sirens's Scream (peppers), Cerberus' Tear (onions), Hades' Ruby (tomatoes), Hephaestus' Forge (jalapenos), Aphrodite's Beauty (cucumbers), Gorgon's Gaze (pickles), Atlas' Hold (guacamole), Centaur's Cap (mushrooms)");
        System.out.println("(Enter: the translated name in parens, 'done' when finished adding toppings): ");
        boolean runningTopping = true;
        while (runningTopping) {
            String toppings = scanner.nextLine();

            if (toppings.equalsIgnoreCase("done")) {
                break;
            }
            if (!toppings.isEmpty()) {
                sandwich.addTopping(toppings);
            }
        }
    }

    private void promptForSauces(Sandwich sandwich) {
        System.out.println("\nSauces: Midas' Touch (mayo), Nike's Triumph (mustard), Cupid's Blood (ketchup), Triton's Cream (ranch), Odyssey Dressing (thousand island), Olympus Zest (vinaigrette), Charon's River (au jus)");
        System.out.println("(Enter: the translated name in parens, 'done' when finished adding sauces): ");
        boolean runningSauce = true;
        while (runningSauce) {
            String sauces = scanner.nextLine();

            if (sauces.equalsIgnoreCase("done")) {
                break;
            }
            if (!sauces.isEmpty()) {
                sandwich.addSauce(sauces);
            }
        }
    }

    private void addSandwich() {
        System.out.println("\n--- Build Your Sandwich ---");
        String breadType = promptForBreadType();
        String size = promptForSize();
        String toasted = promptForToasted();

        Sandwich sandwich = new Sandwich(breadType, size, toasted);

        promptForMeats(sandwich);
        promptForCheeses(sandwich);
        promptForToppings(sandwich);
        promptForSauces(sandwich);

        this.order.addSandwich(sandwich);
        System.out.println("Sandwich added to your order!");
    }

    private void addDrink() {
        System.out.println("\n--- Add a Drink ---");
        System.out.print("Enter drink size (small, medium, large): ");
        String size = getUserInput().toLowerCase();
        System.out.print("Enter drink flavor: ");
        String flavor = getUserInput();

        Drink drink = new Drink(size, flavor);
        order.addDrink(drink);
        System.out.println("Drink added to your order!");
    }

    private void addChips() {
        System.out.println("\n--- Add Chips ---");
        System.out.print("What chips would you like (e.g., Lays, Doritos): ");
        String chip = getUserInput();

        Chips chips = new Chips(chip);
        order.addChips(chips);
        System.out.println("Chips added to your order!");
    }

    // and so on and so on........
    public String getUserInput() {
        String choice = scanner.nextLine();
        return choice;
    }

    private void checkoutOrder() {
        System.out.println("\n--- Checkout ---");
        System.out.println(order.getOrderSummary());

        System.out.print("Confirm order and save receipt? (yes/no): ");
        String confirmChoice = getUserInput();
        if (confirmChoice.equalsIgnoreCase("yes")) {
            ReceiptWriter.saveReceipt(order);
            System.out.println("Order confirmed! Receipt saved.");
        } else {
            System.out.println("Checkout cancelled. Returning to main menu.");
        }
    }
}
