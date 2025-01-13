/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class House extends Facility {
    private String roomStandard;
    private int numberOfFloors;

  public House(String serviceCode, String serviceName, double area, double rentalCost, int maxPeople, String rentalType, String roomStandard, int numberOfFloors) {
        super(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }
    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

   @Override
public String toString() {
    return super.toString() + "," + getRoomStandard() + "," + getNumberOfFloors();
}

    
}
