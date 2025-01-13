/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Customer;

/**
 *
 * @author ACER
 */
public interface ICustomerRepository extends Repository<Customer, List<Customer>> {
    
    List<Customer> readFile(); 
    void writeFile(List<Customer> customers);
}
