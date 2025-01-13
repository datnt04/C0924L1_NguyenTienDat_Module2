/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

 private static final Scanner in = new Scanner(System.in);
    
    public static String checkInputString(String message) {
        System.out.print(message);
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (!result.matches("[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) { 
                System.out.println("Invalid format. Name must start with uppercase letters.");
            } else {
                return result;
            }
            System.out.print("Enter again: ");
        }
    }
    public static String checkInputString2(String message) {
    System.out.print(message);
    while (true) {
        String result = in.nextLine().trim();
        if (result.isEmpty()) {
            System.out.println("Input cannot be empty.");
        } else {
            return result; 
        }
        System.out.print("Enter again: ");
    }
}

    public static double checkInputDouble(String message) {
    System.out.print(message);
    while (true) {
        String input = in.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty. Please enter a valid number.");
            System.out.print("Enter again: ");
            continue;
        }
        try {
            double result = Double.parseDouble(input);
            if (result <= 0) {
                throw new Exception("Value must be greater than zero.");
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter again: ");
    }
}
 
public static double checkInputDoubleOrDefault(String message, double defaultValue) {
    System.out.print(message);
    String input = in.nextLine().trim();  
    if (input.isEmpty()) {
        return defaultValue;  
    }
    try {
        return Double.parseDouble(input);  
    } catch (NumberFormatException e) {
        System.out.println("Gia tri phai hop le giu nguyen mac dinh.");
        return defaultValue;  
    }
}

    public static int checkInputInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= 0) {
                    throw new Exception("Value must be greater than zero.");
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Enter again: ");
        }
    }

    

    public static String checkInputPhoneNumber(String message) {
        System.out.print(message);
        while (true) {
            String result = in.nextLine().trim();
            if (result.matches("0\\d{9}")) { 
                return result;
            } else {
                System.out.println("Invalid phone number. Please enter a valid phone number (10 digits).");
            }
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputID(String message) {
        System.out.print(message);
        while (true) {
            String result = in.nextLine().trim();
            if (result.matches("^(NV|KH)-\\d{4}$")) { 
                return result;
            } else {
                System.out.println("Invalid format. ID must follow NV-YYYY or KH-YYYY.");
            }
            System.out.print("Enter again: ");
        }
    }

   public static Date checkInputDate(String message) {
    System.out.print(message);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);
    while (true) {
        try {
            String dateStr = in.nextLine().trim();
            Date date = sdf.parse(dateStr);
            if (date.after(new Date())) {
                System.out.println("Ngày không được ở tương lai.");
            } else {
                return date; 
            }
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
        }
        System.out.print("Nhập lại: ");
    }
}
       public static String checkInputServiceCode(String message) {
        System.out.print(message);
        while (true) {
            String serviceCode = in.nextLine().trim().toUpperCase();
            
            if (serviceCode.matches("^(HO|RO|VL)-\\d{4}$")) {
                return serviceCode;     
            } else {
                System.out.println("Invalid Service Code. Please enter a valid Service Code (e.g., HO-0001, RO-0002, VL-0003).");
            }
        }
    }
         public static String checkInputIDCard(String message) {
        System.out.print(message);
        while (true) {
            String idCard = in.nextLine().trim();
            
           
            if (idCard.matches("\\d{9}|\\d{12}")) { 
                return idCard; 
            } else {
                System.out.println("ID card pahi co 9 so hoac la 12 so.");
            }
        }
    }
         public static String checkInputEmail(String message) {
    System.out.print(message);
    while (true) {
        String email = in.nextLine().trim();
        
        if (email.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,6}$")) {
            return email;
        } else {
            System.out.println("Invalid email format. Please enter a valid email (e.g., example@example.com).");
        }
        System.out.print("Enter again: ");
    }
}
             public static boolean validateByID(String input, String pattern, String errorMessage) {
        if (!input.matches(pattern)) {
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }
    public static int getValidYear(String message) {
        int year;
        while (true) {
            System.out.print(message);
            try {
                year = Integer.parseInt(in.nextLine());
                // Kiểm tra nếu năm hợp lệ (có thể tùy chỉnh theo yêu cầu)
                if (year >= 1900 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
                    return year;
                } else {
                    System.out.println("Year must be between 1900 and the current year.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid year.");
            }
        }
    }

    // Phương thức để nhập và kiểm tra tháng
    public static int getValidMonth(String message) {
        int month;
        while (true) {
            System.out.print(message);
            try {
                month = Integer.parseInt(in.nextLine());
                // Kiểm tra nếu tháng hợp lệ (1-12)
                if (month >= 1 && month <= 12) {
                    return month;
                } else {
                    System.out.println("Month must be between 1 and 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid month.");
            }
        }
    }
      }



