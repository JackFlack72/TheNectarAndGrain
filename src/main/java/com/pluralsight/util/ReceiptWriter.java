package com.pluralsight.util;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-HHmmss.txt)
        String fileName = generateTimestamp() + ".txt";
        String filePath = "src/main/resources/receipts/" + fileName;
        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts)
        File directory = new File("src/main/resources/receipts/");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // loop through all order items
        //   - write the items to the to reciept
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("=========================================\n");
            writer.write("          The Nectar and Grain Receipt\n");
            writer.write("=========================================\n");
            writer.write("Date: " + getCurrentDateTime() + "\n");
            writer.write("=========================================\n\n");

            // Write sandwiches
            if (!order.getSandwiches().isEmpty()) {
                writer.write("SANDWICHES:\n");
                writer.write("-----------------------------------------\n");
                int sandwichNum = 1;
                for (Sandwich sandwich : order.getSandwiches()) {
                    writer.write("Sandwich #" + sandwichNum + ":\n");
                    writer.write(sandwich.getSummary() + "\n");
                    writer.write(String.format("Price: $%.2f\n\n", sandwich.getPrice()));
                    sandwichNum++;
                }
            }

            // Write drinks
            if (!order.getDrinks().isEmpty()) {
                writer.write("DRINKS:\n");
                writer.write("-----------------------------------------\n");
                for (Drink drink : order.getDrinks()) {
                    writer.write(String.format("%s %s - $%.2f\n",
                            drink.getDrinkSize(),
                            drink.getDrinkFlavor(),
                            drink.getPrice()));
                }
                writer.write("\n");
            }

            // Write chips
            if (!order.getChips().isEmpty()) {
                writer.write("CHIPS:\n");
                writer.write("-----------------------------------------\n");
                for (Chips chips : order.getChips()) {
                    writer.write(String.format("%s - $%.2f\n",
                            chips.getChipsType(),
                            chips.getPrice()));
                }
                writer.write("\n");
            }
            //write total cost
            writer.write("=========================================\n");
            writer.write(String.format("TOTAL: $%.2f\n", order.getTotal()));
            writer.write("=========================================\n");
            writer.write("\nThank you for your order!\n");
            System.out.println("\nReceipt saved to: " + filePath);

            // close BufferedWriter
            // handle IOException with error message
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }


    private static String generateTimestamp() {
        // Create timestamp string useing a formatter
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        // return that string
        return now.format(formatter);
    }

    private static String getCurrentDateTime() {
        // Format: MMMM d, yyyy HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}
