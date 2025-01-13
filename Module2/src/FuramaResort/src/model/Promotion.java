/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Promotion implements Comparable<Promotion> {
    private String customerId;
    private String customerName;
    private int voucher;  // Ensure correct variable name is used for voucher amount

    public Promotion() {
    }

    public Promotion(String customerId, String customerName, int voucher) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.voucher = voucher;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    @Override
    public int compareTo(Promotion other) {
        return this.customerId.compareTo(other.customerId);
    }

    @Override
    public String toString() {
        return String.format("Promotion[customerId=%s, customerName=%s, voucher=%d%%]", customerId, customerName, voucher);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Promotion promotion = (Promotion) obj;
        return customerId.equals(promotion.customerId);
    }

    @Override
    public int hashCode() {
        return customerId.hashCode();
    }
}