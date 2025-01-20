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
import model.Moto;

/**
 *
 * @author ACER
 */
public class MotoRepository implements IMotoRepository {

    @Override
    public List<Moto> readFromFile() {
        List<Moto> motos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String licensePlate = parts[0];
                    String manufacturer = parts[1];
                    int productionYear = Integer.parseInt(parts[2]);
                    String owner = parts[3];
                    int engineCapacity = Integer.parseInt(parts[4]);
                    motos.add(new Moto(engineCapacity, licensePlate, manufacturer, productionYear, owner));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return motos;
    }

    @Override
    public void writeToFile(List<Moto> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Moto moto : data) {
                bw.write(moto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
  public boolean isDuplicate(String licensePlate) {
        List<Moto> motos = readFromFile();
        for (Moto moto : motos) {
            if (moto.getLicensePlate().equals(licensePlate)) {
                return true;
            }
        }
        return false;
    }
}
