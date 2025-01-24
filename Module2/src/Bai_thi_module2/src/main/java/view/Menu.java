/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ACER
 */

import java.util.Scanner;

public class Menu {
    private String title;
    private String[] options;

    public Menu(String title, String[] options) {
        this.title = title;
        this.options = options;
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Chọn một tùy chọn: ");
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 1 || choice > options.length) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > options.length) {
                    System.out.print("Lựa chọn không hợp lệ. Vui lòng thử lại: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập một số hợp lệ: ");
            }
        }
        return choice;
    }
}
