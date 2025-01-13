/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

public class FacilityValidation {
    private static final Scanner scanner = new Scanner(System.in);

    public static String checkInputServiceCode(String message) {
        System.out.print(message);
        while (true) {
            String serviceCode = scanner.nextLine().trim();
            if (serviceCode.matches("(VL|HO|RO)-\\d{4}")) {
                return serviceCode;
            } else {
                System.out.println("Mã dịch vụ không hợp lệ. Vui lòng nhập theo định dạng XX-YYYY (XX là VL, HO, hoặc RO; YYYY là số từ 0-9).");
            }
        }
    }

    public static String checkInputString(String message) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.matches("[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) {
                return input;
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập chuỗi có ký tự đầu viết hoa.");
            }
        }
    }

    public static double checkInputDouble(String message) {
        System.out.print(message);
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Giá trị phải là số dương. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập số.");
            }
        }
    }

    public static int checkInputInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Giá trị phải là số nguyên dương. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
    }

    public static double checkInputArea(String message) {
        System.out.print(message);
        while (true) {
            double area = checkInputDouble(message);
            if (area >= 30) {
                return area;
            } else {
                System.out.println("Diện tích phải lớn hơn hoặc bằng 30m2. Vui lòng nhập lại.");
            }
        }
    }

    public static String checkRentalType(String message) {
        System.out.print(message);
        while (true) {
            String rentalType = scanner.nextLine().trim();
            if (!rentalType.isEmpty() && rentalType.matches("[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) {
                return rentalType;
            } else {
                System.out.println("Kiểu thuê không hợp lệ. Vui lòng nhập chuỗi có ký tự đầu viết hoa.");
            }
        }
    }

    public static String checkRoomStandard(String message) {
        return checkInputString(message);
    }

    public static double checkPoolArea(String message) {
        return checkInputArea(message);
    }
}