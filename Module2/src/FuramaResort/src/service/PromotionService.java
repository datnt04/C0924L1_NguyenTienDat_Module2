/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;
import model.Booking;
import model.Customer;
import model.Promotion;
import repository.PromotionRepository;
import utils.Validation;

/**
 *
 * @author ACER
 */
public class PromotionService implements IPromotionService {
    private final Stack<Customer> customerStack = new Stack<>();
    private final PromotionRepository promotionRepository = new PromotionRepository();
    private final BookingService bookingService = new BookingService();
    private final CustomerService customerService = new CustomerService();
    private final TreeSet<Promotion> promotions = new TreeSet<>();
    private int customerCount = 0;
    private int year; 


       @Override
    public void display() {
        System.out.println("Displaying all bookings:");
    bookingService.displayBookings(); 
           year = Validation.getValidYear("Enter the year: ");
    System.out.printf("%-15s %-15s\n", "Customer ID", "Customer Name");
    
    // Biến đếm số lượng khách hàng
    customerCount = 0;

    // Duyệt qua tất cả bookings
    for (Booking booking : bookingService.getAllBookings()) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(booking.getStartDate()); // Sử dụng ngày bắt đầu
        int bookingYear = cal.get(Calendar.YEAR); // Lấy năm của booking

        // Kiểm tra năm
        if (bookingYear == year) { // Nếu năm khớp
            Customer customer = customerService.findById(booking.getCustomerId()); // Tìm khách hàng theo ID
            if (customer != null) { // Nếu khách hàng tồn tại
                System.out.printf("%-15s %-15s\n", customer.getId(), customer.getName()); // Hiển thị thông tin
                customerCount++; // Tăng biến đếm số lượng khách hàng
            }
        }
    }

    // Nếu không có khách hàng nào, thông báo
    if (customerCount == 0) {
        System.out.println("No customers found for the specified year.");
    } else {
        System.out.println("Total customers: " + customerCount); // Hiển thị tổng số khách hàng
    }
}

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Object findById(String id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void add(Object entity) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void update(Object entity) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void displayHaveDiscount() {
    Stack<Customer> customerStack = new Stack<>();

    // Hiển thị tiêu đề
    System.out.printf("%-15s %-15s\n", "Customer ID", "Customer Name");

    // Duyệt qua tất cả bookings để tìm khách hàng
    for (Booking booking : bookingService.getAllBookings()) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(booking.getStartDate());
        int bookingYear = cal.get(Calendar.YEAR);

        // Chỉ thêm khách hàng vào danh sách nếu năm khớp
        if (bookingYear == year) {
            Customer customer = customerService.findById(booking.getCustomerId());
            if (customer != null) {
                System.out.printf("%-15s %-15s\n", customer.getId(), customer.getName());
                customerStack.push(customer); // Thêm khách hàng vào stack
            }
        }
    }

    // Nếu không có khách hàng nào, thông báo
    if (customerStack.isEmpty()) {
        System.out.println("No customers found for the specified year.");
        return;
    }

    // Nhập số lượng voucher
    int voucher10, voucher20, voucher50;
    do {
        System.out.println("Total customers: " + customerStack.size());
        voucher10 = Validation.checkInputInt("Enter number of 10% vouchers: ");
        voucher20 = Validation.checkInputInt("Enter number of 20% vouchers: ");
        voucher50 = Validation.checkInputInt("Enter number of 50% vouchers: ");

        // Kiểm tra tổng số voucher
        if ((voucher10 + voucher20 + voucher50) != customerStack.size()) {
            System.err.println("Total vouchers must equal the number of customers using service.");
        }
    } while ((voucher10 + voucher20 + voucher50) != customerStack.size());

    // Phân phối voucher
    int voucherType = 50; // Bắt đầu từ voucher 50%
    while (!customerStack.isEmpty() && (voucher50 > 0 || voucher20 > 0 || voucher10 > 0)) {
        Customer customer = customerStack.pop();
        System.out.println("Customer " + customer.getName() + " receives a " + voucherType + "% voucher.");
        promotions.add(new Promotion(customer.getId(), customer.getName(), voucherType));

        // Giảm số lượng voucher
        switch (voucherType) {
            case 50:
                voucher50--;
                break;
            case 20:
                voucher20--;
                break;
            case 10:
                voucher10--;
                break;
        }

        // Chuyển sang loại voucher tiếp theo khi hết
        if (voucherType == 50 && voucher50 == 0) {
            voucherType = 20; // Chuyển sang voucher 20%
        } else if (voucherType == 20 && voucher20 == 0) {
            voucherType = 10; // Chuyển sang voucher 10%
        }
    }

    // Ghi danh sách voucher vào file
    promotionRepository.writeFile(promotions);
}
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}