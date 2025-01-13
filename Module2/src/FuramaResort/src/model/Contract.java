/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class Contract {
    private String contractId;
    private String bookingId;
    private double depositAmount;
    private double totalAmount;
    private Date contractDate;

    public Contract(String contractId, String bookingId, double depositAmount, double totalAmount, Date contractDate) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.contractDate = contractDate;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }





    @Override
    public String toString() {
        return String.format("Contract{ID: %s, Booking ID: %s, Deposit: %.2f, Total: %.2f, Date: %s}", 
                contractId, bookingId, depositAmount, totalAmount, contractDate);
    }
}