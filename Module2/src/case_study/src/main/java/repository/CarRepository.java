/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Car;

/**
 *
 * @author ACER
 */
public class CarRepository implements ICarRepository{
    @Override
    public List<Car> readFromFile() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String licensePlate = parts[0];
                    String manufacturer = parts[1];
                    int productionYear = Integer.parseInt(parts[2]);
                    String owner = parts[3];
                    String type = parts[4];
                    int seats = Integer.parseInt(parts[5]);
                    cars.add(new Car(licensePlate, manufacturer, productionYear, owner, type, seats));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return cars;
    }

    @Override
    public void writeToFile( List<Car> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME ))) {
            for (Car car : data) {
                bw.write(car.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
        public boolean isDuplicate(String licensePlate) {
        List<Car> cars = readFromFile();
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return true;
            }
        }
        return false;
    }

   
}
