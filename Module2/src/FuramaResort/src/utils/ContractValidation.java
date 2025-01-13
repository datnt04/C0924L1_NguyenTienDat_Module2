/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ContractValidation {
       private static final Scanner scanner = new Scanner(System.in);
         public static double checkInputDeposit(String message) {
        System.out.print(message);
        while (true) {
            try {
                double deposit = Double.parseDouble(scanner.nextLine().trim());
                if (deposit >= 0) {
                    return deposit; // Trả về số tiền đặt cọc hợp lệ
                } else {
                    System.out.println("Deposit must be a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid deposit amount format. Please enter a valid number.");
            }
        }
    }

    public static double checkInputTotalAmount(String message) {
        System.out.print(message);
        while (true) {
            try {
                double totalAmount = Double.parseDouble(scanner.nextLine().trim());
                if (totalAmount >= 0) {
                    return totalAmount; 
                } else {
                    System.out.println("Total amount must be a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid total amount format. Please enter a valid number.");
            }
        }
    }


    public static boolean validateDepositAndTotalAmount(double deposit, double totalAmount) {
        if (deposit < 0) {
            System.out.println("Deposit amount cannot be negative.");
            return false;
        }
        if (totalAmount < 0) {
            System.out.println("Total amount cannot be negative.");
            return false;
        }
        if (deposit > totalAmount) {
            System.out.println("Deposit amount cannot be greater than the total amount.");
            return false;
        }
        return true;
    }


    public static boolean validateContractId(String contractId) {
        if (contractId.matches("^CT-\\d{1,4}$")) {
            return true;
        } else {
            System.out.println("Invalid Contract ID format! Must follow the format CT-XXXX.");
            return false;
        }
    }


    public static boolean validateBookingId(String bookingId) {
        if (bookingId.matches("^BK-\\d{4}$")) {
            return true;
        } else {
            System.out.println("Invalid Booking ID format! Must follow the format BK-XXXX.");
            return false;
        }
    }


    public static boolean validateCustomerId(String customerId) {
        if (customerId.matches("^KH-\\d{4}$")) {
            return true;
        } else {
            System.out.println("Invalid Customer ID format! Must follow the format KH-XXXX.");
            return false;
        }
    }
}
