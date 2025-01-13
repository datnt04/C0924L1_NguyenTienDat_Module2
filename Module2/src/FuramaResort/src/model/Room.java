/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Room extends Facility {
    private String freeService;

     public Room(String serviceCode, String serviceName, double area, double rentalCost, int maxPeople, String rentalType, String freeService) {
        super(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType);
        this.freeService = freeService;
    }
    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

 @Override
public String toString() {
    return super.toString() + "," + getFreeService();
}
 
    
}
