/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Contract;

/**
 *
 * @author ACER
 */
public interface IContractService {
    
    
    void initBookingQueue();

   
    void createContractFromEarliestBooking();

    
    void displayAllContracts();

   
    Contract findById(String contractId);

   
    void updateContract();

  
    void saveContracts();
}