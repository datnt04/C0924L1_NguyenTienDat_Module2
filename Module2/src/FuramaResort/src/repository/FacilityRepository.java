/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Facility;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import model.House;
import model.Room;
import model.Villa;

public class FacilityRepository implements IFacilityRepository {
    private static final String FACILITY_FILE_PATH = "src/data/facility.csv";  
private static LinkedHashMap<Facility, Integer> facilityMap = new LinkedHashMap<>();

    @Override
    public LinkedHashMap<Facility, Integer> readFile() {
            facilityMap.clear(); // Clear existing data to avoid duplication
    try (BufferedReader reader = new BufferedReader(new FileReader(FACILITY_FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 7) { // Ensure the length matches the expected number of fields
                String serviceCode = data[0].trim();
                String serviceName = data[1].trim();
                double area = Double.parseDouble(data[2].trim());
                double rentalCost = Double.parseDouble(data[3].trim());
                int maxPeople = Integer.parseInt(data[4].trim());
                String rentalType = data[5].trim();
                int usage = Integer.parseInt(data[6].trim());

                Facility facility = null;
                if (serviceCode.startsWith("VL")) {
                    facility = new Villa(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType, "Standard", 0, 0);
                } else if (serviceCode.startsWith("HO")) {
                    facility = new House(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType, "Standard", 0);
                } else if (serviceCode.startsWith("RO")) {
                    facility = new Room(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType, "Free Service");
                }

                if (facility != null) {
                    facilityMap.put(facility, usage);
                    // Log the facility loaded
                 //   System.out.println("Loaded facility: " + serviceCode + " - " + serviceName);
                }
            } else {
                System.out.println("Invalid data format in facility file: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading facility file: " + e.getMessage());
    }
    return new LinkedHashMap<>(facilityMap);
}
    
    public void add(Facility facility) {
        facilityMap.put(facility, 0); // Add new facility with usage count of 0
        writeFile(new LinkedHashMap<>(facilityMap)); // Write to file
    }

    @Override
    public void writeFile(Map<Facility, Integer> facilities) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FACILITY_FILE_PATH))) {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                Facility facility = entry.getKey();
                int usage = entry.getValue();
                writer.write(facility.getServiceCode() + "," + facility.getServiceName() + "," + 
                             facility.getArea() + "," + facility.getRentalCost() + "," + 
                             facility.getMaxPeople() + "," + facility.getRentalType() + "," + usage);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing facility file: " + e.getMessage());
        }
    }

     public void incrementUsage(String serviceCode) {
    for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
        if (entry.getKey().getServiceCode().equals(serviceCode)) {
            entry.setValue(entry.getValue() + 1); // Tăng số lần sử dụng
            writeFile(facilityMap); // Ghi lại vào file
            System.out.println("Usage count updated for facility: " + serviceCode);
            break;
        }
    }
}
public Facility findById(String id) {
    String normalizedId = id.trim().toUpperCase(); 

    for (Facility facility : facilityMap.keySet()) { 
        if (facility.getServiceCode().trim().equalsIgnoreCase(normalizedId)) { 
            return facility; 
        }
    }
    
    return null; 
}
}

