/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_1;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class CurrencyConverter {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền USD: ");
        String input = scanner.nextLine();  
        double usd = Double.parseDouble(input);
        double vnd = usd * 23000;  
        System.out.printf("%.2f USD = %.2f VND%n", usd, vnd);
    }
}
