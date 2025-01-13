/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */

  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


   public class Employee extends Person {
    private String qualification;
    private String position;
    private double salary;
    private String educationLevel;

    public Employee( String id, String name, Date birthDate, String gender, String idCard, String phoneNumber, String email,String qualification, String position, double salary) {
        super(id, name, birthDate, gender, idCard, phoneNumber, email);
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

   

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
    return "ID: " + this.id +
           ", Name: " + this.name +
           ", Birth Date: " + this.birthDate +
           ", Gender: " + this.gender +
           ", ID Card: " + this.idCard +
           ", Phone: " + this.phoneNumber +
           ", Email: " + this.email +
           ", Education Level: " + this.educationLevel +
           ", Position: " + this.position +
           ", Salary: " + this.salary;
}
    
   
}

