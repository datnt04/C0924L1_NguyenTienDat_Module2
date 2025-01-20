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
import model.Truck;

/**
 *
 * @author ACER
 */
public class TruckRepository implements ITruckRepository{

    @Override
    public List<Truck> readFromFile() {
        List<Truck> trucks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String licensePlate = parts[0];
                    String manufacturer = parts[1];
                    int productionYear = Integer.parseInt(parts[2]);
                    String owner = parts[3];
                    double payload = Double.parseDouble(parts[4]);
                    trucks.add(new Truck(licensePlate, manufacturer, productionYear, owner, payload));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return trucks;
    }
      public boolean isDuplicate(String licensePlate) {
        List<Truck> trucks = readFromFile();
        for (Truck truck : trucks) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void writeToFile( List<Truck> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Truck truck : data) {
                bw.write(truck.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
