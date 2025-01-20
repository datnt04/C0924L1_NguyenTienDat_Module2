/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public abstract class Vehicle {
    private String licensePlate;
    private String manufacturer;
    private int productionYear;
    private String owner;

    public Vehicle(String licensePlate, String manufacturer, int productionYear, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate=" + licensePlate + ", manufacturer=" + manufacturer + ", productionYear=" + productionYear + ", owner=" + owner + '}';
    }
   
}
