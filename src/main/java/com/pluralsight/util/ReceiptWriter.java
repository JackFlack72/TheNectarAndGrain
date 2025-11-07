package com.pluralsight.util;

import com.pluralsight.model.Order;

import java.io.FileWriter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-HHmmss.txt)
        String fileName = generateTimestamp() + ".txt";
        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts)

        // loop through all order items
        //   - write the items to the to reciept
        try {
            FileWriter writer = new FileWriter();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //write total cost

        // close BufferedWriter
        // handle IOException with error message
    }

    private static String generateTimestamp() {
        // Create timestamp string useing a formatter
        // return that string
}
