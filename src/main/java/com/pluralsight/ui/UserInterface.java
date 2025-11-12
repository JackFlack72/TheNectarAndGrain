package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.util.Scanner;

public class UserInterface {
    // declare a Scanner object for reading input from the console
    private Order order;
    private Scanner scanner = new Scanner(System.in);

    // constructor:


    public void display() {
        boolean running = true;
    }

    // showHomeScreen:
    public String showHomeScreen() {
        //   - print app title and welcome message
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      Welcome to The Nectar and Grain!       ║");
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
        //   - print:
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
        return getUserInput();
    }

    // promptForBreadType:
    private String promptForBreadType() {
        //   - print list of bread types
        System.out.println("\nBread: Delphi (white), Olympus (wheat), Athens (rye), Sparta (wrap)");
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
    private String promptForMeats(Sandwich sandwich) {
        //   - possible loop (one or multiple meats?):
        //       - ask user to type of meat (or 'done' to finish)
        //       - ask if they want Extra meat? (yes or no)"
        //   - return list of meats and extras
        System.out.println("\nMeats: Atlas (steak), Achilles (ham), Perseus (salami), Hercules (roast beef), Apollo (chicken), Ares (bacon)");
        System.out.println("(Enter 'done' when finished adding meats)");
        boolean running = true;
        while (running) {
            String meats = scanner.nextLine();

            if (meats.equalsIgnoreCase("done")) {
                break;
            }
        }
    }

    // and so on and so on........
    public String getUserInput() {
        String choice = scanner.nextLine();
        return choice;
    }
}
