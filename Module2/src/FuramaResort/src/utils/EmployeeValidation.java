/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class EmployeeValidation {
   private static final Scanner scanner = new Scanner(System.in);

    public static String checkEmployeeId(String message) {
        System.out.print(message);
        while (true) {
            String id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Employee ID cannot be empty.");
            } else if (id.matches("NV-\\d{4}")) {
                return id;
            } else {
                System.out.println("Invalid Employee ID format. Please enter NV-YYYY.");
            }
        }
    }
         public static String checkInputEmail(String message) {
    System.out.print(message);
    while (true) {
        String email = scanner.nextLine().trim();
        
        if (email.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,6}$")) {
            return email;
        } else {
            System.out.println("Invalid email format. Please enter a valid email (e.g., example@example.com).");
        }
        System.out.print("Enter again: ");
    }
}
    public static String checkName(String message) {
        System.out.print(message);
        while (true) {
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else if (name.matches("[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) {
                return name;
            } else {
                System.out.println("Name must start with uppercase letters.");
            }
        }
    }

    public static double checkSalary(String message) {
        System.out.print(message);
        while (true) {
            String salaryStr = scanner.nextLine().trim();
            if (salaryStr.isEmpty()) {
                System.out.println("Salary cannot be empty.");
            } else {
                try {
                    double salary = Double.parseDouble(salaryStr);
                    if (salary > 0) {
                        return salary;
                    } else {
                        System.out.println("Salary must be greater than 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary format. Please enter a number.");
                }
            }
        }
    }

    public static Date checkBirthDate(String message) {
        System.out.print(message);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            String dateStr = scanner.nextLine().trim();
            if (dateStr.isEmpty()) {
                System.out.println("Birth date cannot be empty.");
            } else {
                try {
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
    }

    public static String checkIdCard(String message) {
        System.out.print(message);
        while (true) {
            String idCard = scanner.nextLine().trim();
            if (idCard.isEmpty()) {
                System.out.println("ID card cannot be empty.");
            } else if (idCard.matches("\\d{9}|\\d{12}")) {
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
            if (phoneNumber.isEmpty()) {
                System.out.println("Phone number cannot be empty.");
            } else if (phoneNumber.matches("0\\d{9}")) {
                return phoneNumber;
            } else {
                System.out.println("Phone number must start with 0 and have 10 digits.");
            }
        }
    }

    public static String checkEmail(String message) {
        System.out.print(message);
        while (true) {
            String email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty.");
            } else if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                return email;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
    }

    public static String checkNotEmpty(String message, String fieldName) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty.");
            } else {
                return input;
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
         public static String checkInputPosition(String message, String position) {
        System.out.print(message);
        while (true) {
             position = scanner.nextLine().trim();
            if (position.equalsIgnoreCase("Nhân viên") || 
                position.equalsIgnoreCase("Giám đốc") || 
                position.equalsIgnoreCase("Kế toán") || 
                position.equalsIgnoreCase("An ninh")) {
                return position;
            } else {
                System.out.println("Vị trí không hợp lệ. Vui lòng nhập lại (Nhân viên, Giám đốc, Kế toán, An ninh).");
            }
        }
    }
}


