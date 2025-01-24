/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respository;

import java.util.List;

/**
 *
 * @author ACER
 */

public interface Repository<T> {
    List<T> readFromFile(); 
    void writeToFile(List<T> items); 
}
