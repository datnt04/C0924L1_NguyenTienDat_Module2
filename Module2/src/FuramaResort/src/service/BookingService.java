/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import model.Booking;
import repository.BookingRepository;
import repository.FacilityRepository;

import utils.BookingValidation;


/**
 *
 * @author ACER
 */
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository = new BookingRepository();
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService = new CustomerService();
    private final FacilityService facilityService = new FacilityService();
     private final FacilityRepository facilityRepository = new FacilityRepository();
        @Override
    public void add(Booking entity) {
        bookingRepository.addBooking(entity);
        System.out.println("Booking added successfully.");
        
    }

    @Override
    public void display() {
        displayBookings();
    }

    @Override
    public void addBooking() {
    String bookingId;
    while (true) {
        bookingId = BookingValidation.checkInputBookingID("Enter Booking ID (BKx): ");

        // Check for duplicate Booking ID
        if (findById(bookingId) != null) {
            System.out.println("Booking ID already exists. Please enter a unique ID.");
        } else {
            break; // Exit loop if Booking ID is unique
        }
    }

    Date bookingDate = BookingValidation.checkInputDate("Enter Booking Date (dd/MM/yyyy): ");
    Date startDate = BookingValidation.checkInputDate("Enter Start Date (dd/MM/yyyy): ");
    Date endDate = BookingValidation.checkInputDate("Enter End Date (dd/MM/yyyy): ");
    
    // Loop until a valid Customer ID is entered
    String customerId;
    while (true) {
        customerId = BookingValidation.checkInputCustomerID("Enter Customer ID (KH-XXXX): ");
        if (customerService.findById(customerId) != null) { // Assumes customerService is accessible in this context
            break; // Customer ID exists, exit loop
        } else {
            System.out.println("Customer ID does not exist. Please enter a valid Customer ID.");
        }
    }

    String serviceCode;
    while (true) {
        facilityService.display();
        serviceCode = BookingValidation.checkInputServiceCode("Enter Service Code (VL-XXXX, HO-XXXX, RO-XXXX): ");
        
        if (facilityRepository.findById(serviceCode) == null) { 
            System.out.println("Service Code does not exist. Please enter a valid Service Code.");
        } else {
            break; 
        }
    }

    if (startDate.after(endDate)) {
        System.out.println("Start date cannot be after end date.");
        return;
    }

    Booking booking = new Booking(bookingId, bookingDate, startDate, endDate, customerId, serviceCode);
    add(booking);
    System.out.println("Booking added successfully.");
}
@Override
public void displayBookings() {
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    bookingRepository.readFile(); 
    TreeSet<Booking> bookings = getAllBookings();
    
    if (bookings.isEmpty()) {
        System.out.println("No bookings found.");
    } else {
        // Header row for the booking details
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", 
                          "Booking ID", "Booking Date", "Start Date", "End Date", "Customer ID", "Service Code");
        System.out.println("--------------------------------------------------------------------------------");

        for (Booking booking : bookings) {
            System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", 
                              booking.getBookingId(), 
                              dateFormat.format(booking.getBookingDate()), 
                              dateFormat.format(booking.getStartDate()), 
                              dateFormat.format(booking.getEndDate()), 
                              booking.getCustomerId(), 
                              booking.getServiceCode());
        }
        
        System.out.println("End of booking list."); 
    }
}

    @Override
    public TreeSet<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public Booking findById(String id) {
        TreeSet<Booking> bookings = getAllBookings();
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public void save() {
        TreeSet<Booking> bookings = getAllBookings();
        bookingRepository.writeFile(bookings);
        System.out.println("Bookings saved successfully.");
    }

    @Override
    public void update() {
        System.out.print("Enter Booking ID to update: ");
        String id = scanner.nextLine();

        Booking booking = findById(id);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        Date newStartDate = BookingValidation.checkInputDate("Enter new Start Date (dd/MM/yyyy): ");
        Date newEndDate = BookingValidation.checkInputDate("Enter new End Date (dd/MM/yyyy): ");

        if (newStartDate.after(newEndDate)) {
            System.out.println("Start date cannot be after end date.");
            return;
        }

        booking.setStartDate(newStartDate);
        booking.setEndDate(newEndDate);

        save(); 
        System.out.println("Booking updated successfully.");
    }
}