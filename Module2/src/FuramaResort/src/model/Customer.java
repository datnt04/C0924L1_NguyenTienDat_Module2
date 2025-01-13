/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer(String id, String name, Date birthDate, String gender, String idCard, String phoneNumber, String email, String customerType, String address) {
        super(id, name, birthDate, gender, idCard, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", birthDate=" + getBirthDate() +
                ", gender=" + getGender() +
                ", idCard=" + getIdCard() +
                ", phoneNumber=" + getPhoneNumber() +
                ", email=" + getEmail() +
                ", customerType=" + customerType +
                ", address=" + address +
                '}';
    }
}