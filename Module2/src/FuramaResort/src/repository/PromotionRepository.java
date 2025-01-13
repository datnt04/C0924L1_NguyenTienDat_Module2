/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;
import model.Booking;
import model.Customer;
import model.Promotion;
import service.CustomerService;

/**
 *
 * @author ACER
 */
public class PromotionRepository implements IPromotionRepository {

    @Override
    public TreeSet<Promotion> readFile() {
         TreeSet<Promotion> promotions = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String customerId = data[0];
                    String customerName = data[1];
                    int voucher = Integer.parseInt(data[2]);

                    Promotion promotion = new Promotion(customerId, customerName, voucher);
                    promotions.add(promotion);
                } else {
                    System.err.println("Invalid promotion record: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading promotions from file: " + e.getMessage());
        }
        return promotions;
    }

    @Override
    public void writeFile(TreeSet<Promotion> promotions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            for (Promotion promotion : promotions) {
                writer.write(String.format("%s,%s,%d", 
                    promotion.getCustomerId(), 
                    promotion.getCustomerName(), 
                    promotion.getVoucher()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing promotions to file: " + e.getMessage());
        }
    }
}