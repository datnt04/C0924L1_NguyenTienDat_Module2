/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import model.Booking;
import model.Contract;
import model.Facility;
import repository.BookingRepository;
import repository.ContractRepository;
import repository.FacilityRepository;
import utils.ContractValidation;
import utils.Validation;

/**
 *
 * @author ACER
 */
public class ContractService implements IContractService {
 private final ContractRepository contractRepository = new ContractRepository();
    private final BookingRepository bookingRepository = new BookingRepository();
    private final FacilityRepository facilityRepository = new FacilityRepository();
    private final Queue<Booking> contractQueue = new LinkedList<>();
    private final Scanner scanner = new Scanner(System.in);
 private final Set<String> processedBookings = new HashSet<>();
    @Override
    public void initBookingQueue() {
        contractQueue.clear();
        for (Booking booking : bookingRepository.getAllBookings()) {
            if (processedBookings.contains(booking.getBookingId())) {
                System.out.println("Skipping duplicate booking: " + booking.getBookingId());
                continue;
            }
            if (!booking.getServiceCode().matches("(RO|HO|VL)-\\d{4}")) {
                System.out.println("Invalid Service Code format: " + booking.getServiceCode());
                continue;
            }
            contractQueue.add(booking);
        }
    }

    @Override
    public void createContractFromEarliestBooking() {
 do {
            facilityRepository.readFile();

            if (contractQueue.isEmpty()) {
                System.out.println("No bookings available for contract creation.");
                return;
            }

            Booking earliestBooking = contractQueue.poll();
            if (processedBookings.contains(earliestBooking.getBookingId())) {
                System.out.println("Skipping duplicate booking: " + earliestBooking.getBookingId());
                continue;
            }

            String serviceCode = earliestBooking.getServiceCode();
            Facility facility = facilityRepository.findById(serviceCode);

            if (facility == null) {
                System.out.println("Error: Facility not found for booking with Facility ID: " + serviceCode);
                return;
            }

            long rentalDays = calculateDays(earliestBooking.getStartDate(), earliestBooking.getEndDate());
            double totalAmount = calculateTotalCost(rentalDays, facility);
            System.out.printf("Total amount for the booking: %.2f\n", totalAmount);

            double deposit;
            while (true) {
                deposit = ContractValidation.checkInputDeposit("Enter deposit amount: ");
                if (deposit < totalAmount) {
                    break;
                }
                System.out.println("Deposit amount must be less than the total amount. Please try again.");
            }

            double remainingAmount = totalAmount - deposit;

            String contractId = "CT-" + System.currentTimeMillis();
            Contract contract = new Contract(contractId, earliestBooking.getBookingId(), deposit, totalAmount, new Date());
            contractRepository.addContract(contract);

            // Lưu bookingId vào danh sách đã xử lý
            processedBookings.add(earliestBooking.getBookingId());

            System.out.println("Contract created successfully for Booking ID: " + earliestBooking.getBookingId());
            System.out.printf("Contract ID: %s\n", contractId);
            System.out.printf("Total Amount: %.2f\n", totalAmount);
            System.out.printf("Deposit: %.2f\n", deposit);
            System.out.printf("Remaining Balance: %.2f\n", remainingAmount);

            System.out.print("Do you want to create another contract? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (!choice.equals("Y")) {
                break;
            }

        } while (true);
    }

    private long calculateDays(Date startDate, Date endDate) {
        long diffInMillis = endDate.getTime() - startDate.getTime();
        return diffInMillis / (1000 * 60 * 60 * 24);
    }

    private double calculateTotalCost(long days, Facility facility) {
        double dailyRate = facility.getRentalCost();
        String rentalType = facility.getRentalType().toLowerCase();

        switch (rentalType) {
            case "day":
                return days * dailyRate;
            case "week":
                return (days / 7.0) * dailyRate;
            case "month":
                return (days / 30.0) * dailyRate;
            default:
                System.out.println("Unknown rental type. Defaulting to daily rate.");
                return days * dailyRate;
        }
    }

    @Override
    public void displayAllContracts() {
        List<Contract> contracts = contractRepository.readFile();
    if (contracts.isEmpty()) {
        System.out.println("No contracts available.");
        return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Contract ID", "Booking ID", "Deposit", "Total Amount", "Contract Date");
    for (Contract contract : contracts) {
        String formattedDate = sdf.format(contract.getContractDate());
        System.out.printf("|%-15s|%-15s|%-15.2f|%-15.2f|%-15s|\n",
                contract.getContractId(),
                contract.getBookingId(),
                contract.getDepositAmount(),
                contract.getTotalAmount(),
                formattedDate);
    }
}

    @Override
    public Contract findById(String contractId) {
        return contractRepository.getAllContracts().stream()
                .filter(contract -> contract.getContractId().equals(contractId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateContract() {
        System.out.print("Enter Contract ID to update: ");
        String contractId = scanner.nextLine();
        Contract contract = findById(contractId);

        if (contract == null) {
            System.out.println("Contract not found.");
            return;
        }

        double newDeposit = ContractValidation.checkInputDeposit("Enter new deposit amount: ");
        contract.setDepositAmount(newDeposit);

        double newTotalPayment = ContractValidation.checkInputTotalAmount("Enter new total payment amount: ");
        contract.setTotalAmount(newTotalPayment);

        saveContracts();
        System.out.println("Contract updated successfully.");
    }

    @Override
    public void saveContracts() {
        contractRepository.writeFile(new LinkedList<>(contractRepository.getAllContracts()));
    }
}
