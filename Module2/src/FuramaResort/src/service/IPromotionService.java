/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ACER
 */
public interface IPromotionService extends Service {
    @Override
    void display();

    @Override
    void save();
    
    void displayHaveDiscount();
}