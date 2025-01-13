/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Comparator;
import model.Booking;

/**
 *
 * @author ACER
 */
public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking b1, Booking b2) {
        
        int startCompare = b1.getStartDate().compareTo(b2.getStartDate());
        
        return startCompare;
    }
}
