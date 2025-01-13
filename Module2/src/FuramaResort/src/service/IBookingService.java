/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.TreeSet;
import model.Booking;

/**
 *
 * @author ACER
 */
public interface IBookingService extends Service<Booking> {
    void addBooking(); 
    void displayBookings(); 
    TreeSet<Booking> getAllBookings(); 
}

