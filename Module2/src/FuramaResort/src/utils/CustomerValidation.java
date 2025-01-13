/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerValidation {
    private static final Scanner scanner = new Scanner(System.in);
     private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    public static String checkCustomerId(String message) {
        System.out.print(message);
        while (true) {
            String id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Customer ID cannot be empty.");
            } else if (id.matches("KH-\\d{4}")) {
                return id;
            } else {
                System.out.println("Invalid Customer ID format. Please enter KH-YYYY.");
            }
        }
    }

    public static String checkName(String message) {
        System.out.print(message);
        while (true) {
            String name = scanner.nextLine().trim();
            if (name.matches("[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) {
                return name;
            } else {
                System.out.println("Name must start with uppercase letters.");
            }
        }
    }

    public static Date checkBirthDate(String message) {
        System.out.print(message);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            try {
                String dateStr = scanner.nextLine().trim();
                Date date = sdf.parse(dateStr);
                if (date.after(new Date())) {
                    System.out.println("Birth date cannot be in the future.");
                } else {
                    return date; 
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter in the format dd/MM/yyyy.");
            }
        }
    }

    public static String checkIdCard(String message) {
        System.out.print(message);
        while (true) {
            String idCard = scanner.nextLine().trim();
            if (idCard.matches("\\d{9}|\\d{12}")) {
                return idCard;
            } else {
                System.out.println("ID card must have 9 or 12 digits.");
            }
        }
    }

    public static String checkPhoneNumber(String message) {
        System.out.print(message);
        while (true) {
            String phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.matches("0\\d{9}")) {
                return phoneNumber;
            } else {
                System.out.println("Phone number must start with 0 and have 10 digits.");
            }
        }
    }

    public static String checkNotEmpty(String message, String fieldName) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println(fieldName + " cannot be empty.");
            }
        }
    }
           public static String checkInputEmail(String message,String email ) {
        System.out.print(message);
        while (true) {
             email = scanner.nextLine().trim();
            if (Pattern.matches(EMAIL_PATTERN, email)) {
                return email; 
            } else {
                System.out.println("Địa chỉ email không hợp lệ. Vui lòng nhập lại (ví dụ: example@domain.com).");
            }
        }
    }
                 public static String checkInputGender(String message,String gender) {
        System.out.print(message);
        while (true) {
             gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("Nam") || gender.equalsIgnoreCase("Nữ") || gender.equalsIgnoreCase("Khác")) {
                return gender;
            } else {
                System.out.println("Giới tính không hợp lệ. Vui lòng nhập lại (Nam, Nữ, Khác).");
            }
        }
    }
                 public static String checkInputMembershipLevel(String message,String customer_Type) {
        System.out.print(message);
        while (true) {
            String level = scanner.nextLine().trim();
            if (level.equalsIgnoreCase("Silver") || 
                level.equalsIgnoreCase("Diamond") || 
                level.equalsIgnoreCase("Bronze")||
                level.equalsIgnoreCase("Gold")) {
                return level;
            } else {
                System.out.println("Cấp độ khách hàng không hợp lệ. Vui lòng nhập lại (Silver, Diamond, Bronze).");
            }
        }
    }
}

