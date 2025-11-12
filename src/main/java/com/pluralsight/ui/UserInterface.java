package com.pluralsight.ui;

import com.pluralsight.model.Order;

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
    public int showHomeScreen() {
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
    //   - print:
    //       1) Add Sandwich
    //       2) Add Drink
    //       3) Add Chips
    //       4) Checkout
    //       0) Cancel Order
    //   - prompt user for choice
    //   - return user input

    // promptForBreadType:
    public int promptForBreadType() {

    }
    //   - print list of bread types
    //   - ask user to type one in (e.g., "white")
    //   - return as user input

    // promptForSize:
    //   - ask user: "What size? (4, 8, or 12 inches)"
    //   - return user input

    // promptForToasted:
    //   - ask: "Would you like it toasted? (yes or no)"
    //   - return user input

    // promptForMeats:
    //   - possible loop (one or multiple meats?):
    //       - ask user to type of meat (or 'done' to finish)
    //       - ask if they want Extra meat? (yes or no)"
    //   - return list of meats and extras

    // and so on and so on........
    public int getUserInput() {

    }
}
