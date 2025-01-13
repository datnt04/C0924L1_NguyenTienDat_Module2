/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Customer;

/**
 *
 * @author ACER
 */
public interface ICustomerService extends Service<Customer>{

    @Override
    public void save();

    @Override
    public void add(Customer entity);

    @Override
    public void display();

    @Override
    public Customer findById(String id);
    
    @Override
    void update();
}
