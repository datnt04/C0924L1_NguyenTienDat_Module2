/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.TreeSet;
import model.Booking;

/**
 *
 * @author ACER
 */
public interface IBookingRepository extends Repository<Booking, TreeSet<Booking>> {
  
    TreeSet<Booking> getAllBookings();
    void addBooking(Booking booking);
    TreeSet<Booking> readFile();
    void writeFile(TreeSet<Booking> entities); 
}

