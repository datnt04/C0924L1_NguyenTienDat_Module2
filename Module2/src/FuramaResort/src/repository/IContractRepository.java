/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.Queue;
import model.Contract;

/**
 *
 * @author ACER
 */
public interface IContractRepository {
  
    void addContract(Contract contract);

    
            Queue<Contract> getAllContracts();
    
    void writeFile(List<Contract> contracts);

  
    List<Contract> readFile();
}
