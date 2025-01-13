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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Customer;

/**
 *
 * @author ACER
 */

    public class CustomerRepository implements ICustomerRepository {

    private static final String CUSTOMER_FILE_PATH = "D:\\Kì 3\\FuramaResort\\src\\data\\Customer.csv"; 

  
  @Override
public List<Customer> readFile() {
    List<Customer> customers = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 9) {
                try {
                    Date birthDate = sdf.parse(data[2]); // Parse ngày tháng với định dạng dd-MM-yyyy
                    Customer customer = new Customer(
                        data[0], 
                        data[1], 
                        birthDate, 
                        data[3], 
                        data[4],
                        data[5], 
                        data[6], 
                        data[7], 
                        data[8]  
                    );
                    customers.add(customer);
                } catch (ParseException e) {
                    System.out.println("Error parsing birth date for customer with ID: " + data[0]);
                }
            } else {
                System.out.println("Invalid data format: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return customers;
}
@Override
public void writeFile(List<Customer> customers) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_FILE_PATH))) {
        for (Customer customer : customers) {
            writer.write(customer.getId() + "," +
                         customer.getName() + "," +
                         new SimpleDateFormat("dd-MM-yyyy").format(customer.getBirthDate()) + "," + // Định dạng ngày sinh
                         customer.getGender() + "," +
                         customer.getIdCard() + "," +
                         customer.getPhoneNumber() + "," +
                         customer.getEmail() + "," +
                         customer.getCustomerType() + "," +
                         customer.getAddress()); // Ghi thêm cả địa chỉ
            writer.newLine(); 
        }
        System.out.println("Customer data written successfully to " + CUSTOMER_FILE_PATH);
    } catch (IOException e) {
        System.out.println("Error while writing customer file: " + e.getMessage());
        e.printStackTrace();
    }
}
    }
    

