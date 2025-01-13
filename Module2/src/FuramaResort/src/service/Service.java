/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ACER
 */
public interface Service<T> {
    T findById(String id);
    void display(); 
    void add(T entity); 
    void save(); 
    void update();
}