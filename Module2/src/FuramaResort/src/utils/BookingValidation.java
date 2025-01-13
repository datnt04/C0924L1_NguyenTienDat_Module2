/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class BookingValidation {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    static {
        sdf.setLenient(false); 
    }

    
    public static Date checkInputDate(String message) {
        System.out.print(message);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    while (true) {
        try {
            String dateStr = scanner.nextLine().trim();
            LocalDate enteredDate = LocalDate.parse(dateStr, formatter);
            LocalDate today = LocalDate.now();

            if (enteredDate.isBefore(today)) {
                System.out.println("Booking khong the o tuong lại chi co the ơ hien tai hoac tuong lai.");
                continue; 
            }

            Date date = java.sql.Date.valueOf(enteredDate);
            return date; 

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
        }
    }
}

    public static String checkInputBookingID(String message) {
        System.out.print(message);
        while (true) {
            String id = scanner.nextLine().trim();
            if (id.matches("BK\\d+")) { 
                return id; 
            } else {
                System.out.println("Invalid Booking ID format. Please enter a valid Booking ID (e.g., BK1).");
            }
        }
    }
 
 
    public static String checkInputCustomerID(String message) {
        System.out.print(message);
        while (true) {
            String id = scanner.nextLine().trim();
            if (id.matches("KH-\\d{4}")) { // Kiểm tra định dạng ID khách hàng như KH-0001
                return id; // Trả về ID hợp lệ
            } else {
                System.out.println("Invalid Customer ID format. Please enter a valid Customer ID (e.g., KH-0001).");
            }
        }
    }

   
    public static String checkInputServiceCode(String message) {
         System.out.print(message);
    while (true) {
        String code = scanner.nextLine().trim();
        if (code.matches("(VL|HO|RO)-\\d{4}")) { 
            return code; 
        } else {
            System.out.println("Invalid Service Code format. Please enter a valid Service Code (e.g., VL-0001, HO-0002, RO-0003).");
        }
    }
}
}
