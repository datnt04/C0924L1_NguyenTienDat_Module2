/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import model.Contract;

import model.Contract;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ContractRepository implements IContractRepository {
     private static final Queue<Contract> contracts = new LinkedList<>();
    private static final String CONTRACT_FILE_PATH = "D:\\Kì 3\\FuramaResort\\src\\data\\Contract.csv";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
   public List<Contract> readFile() {
      contracts.clear(); 
    List<Contract> contractsFromFile = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(CONTRACT_FILE_PATH))) {
        String line;
        boolean isFirstLine = true;
        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false; // Skip header line
                continue;
            }
           
            System.out.println("Reading line: " + line);

            String[] data = line.trim().split(",");
            if (data.length == 5) {
                try {
                    String contractId = data[0].trim();
                    String bookingId = data[1].trim();
                    double depositAmount = Double.parseDouble(data[2].trim());
                    double totalAmount = Double.parseDouble(data[3].trim());
                    Date contractDate = sdf.parse(data[4].trim()); 

                    Contract contract = new Contract(contractId, bookingId, depositAmount, totalAmount, contractDate);
                    contractsFromFile.add(contract);
                    System.out.println("Loaded contract: " + contract);
                } catch (NumberFormatException | ParseException e) {
                    System.out.println("Skipping invalid line: " + line + " - Error: " + e.getMessage());
                }
            } else {
                System.out.println("Skipping malformed line: " + line);
            }
        }
        contracts.addAll(contractsFromFile);
        System.out.println("Total contracts loaded: " + contracts.size()); 
    } catch (IOException e) {
        System.err.println("Error reading contract file: " + e.getMessage());
    }
    return contractsFromFile;
}
    @Override
    public void writeFile(List<Contract> contracts) {
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACT_FILE_PATH, false))) { // Ghi đè toàn bộ file
        writer.write("ContractId,BookingId,DepositAmount,TotalAmount,ContractDate");
        writer.newLine();

        for (Contract contract : contracts) {
            writer.write(String.join(",",
                contract.getContractId(),
                contract.getBookingId(),
                String.valueOf(contract.getDepositAmount()),
                String.valueOf(contract.getTotalAmount()),
                sdf.format(contract.getContractDate())
            ));
            writer.newLine();
        }
        System.out.println("Contracts written successfully to the file.");
    } catch (IOException e) {
        System.err.println("Error writing contracts to file: " + e.getMessage());
    }
}


    @Override
    public void addContract(Contract contract) {
        contracts.add(contract);
        writeFile(new ArrayList<>(contracts));
    }

    @Override
    public Queue<Contract> getAllContracts() {
        return contracts;
    }
}