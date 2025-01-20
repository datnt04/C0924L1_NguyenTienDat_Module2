/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ACER
 */
import java.util.List;
import model.Car;
import model.Moto;
import model.Truck;
import repository.CarRepository;
import repository.MotoRepository;
import repository.TruckRepository;
import java.util.Scanner;

public class VehicleService {

   
    private final CarRepository carRepository = new CarRepository();
    private final TruckRepository truckRepository = new TruckRepository();
    private final MotoRepository motoRepository = new MotoRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void addVehicle() {
        System.out.println("Chọn loại phương tiện để thêm:");
        System.out.println("1. Ô tô");
        System.out.println("2. Xe tải");
        System.out.println("3. Xe máy");
        System.out.print("Lựa chọn của bạn: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập một số hợp lệ.");
            return;
        }

        switch (choice) {
            case 1:
                addCar();
                break;
            case 2:
                addTruck();
                break;
            case 3:
                addMoto();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void addCar() {
        System.out.print("Nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();

        if (carRepository.isDuplicate(licensePlate)) {
            System.out.println("Biển kiểm soát đã tồn tại.");
            return;
        }

        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int productionYear = getIntInput("Năm sản xuất phải là số: ");
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        System.out.print("Nhập loại xe (VD: SUV, Sedan): ");
        String type = scanner.nextLine();
        System.out.print("Nhập số ghế: ");
        int seats = getIntInput("Số ghế phải là số: ");

        Car car = new Car(licensePlate, manufacturer, productionYear, owner, type, seats);
        List<Car> cars = carRepository.readFromFile(); 
        cars.add(car); 
        carRepository.writeToFile(cars); 
        System.out.println("Thêm ô tô thành công.");
    }

    private void addTruck() {
        System.out.print("Nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();

        if (truckRepository.isDuplicate(licensePlate)) {
            System.out.println("Biển kiểm soát đã tồn tại.");
            return;
        }

        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int productionYear = getIntInput("Năm sản xuất phải là số: ");
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập tải trọng (kg): ");
        double payload = getDoubleInput("Tải trọng phải là số: ");

        Truck truck = new Truck(licensePlate, manufacturer, productionYear, owner, payload);
        List<Truck> trucks = truckRepository.readFromFile(); 
        trucks.add(truck); 
        truckRepository.writeToFile(trucks); 
        System.out.println("Thêm xe tải thành công.");
    }

    private void addMoto() {
        System.out.print("Nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();

        if (motoRepository.isDuplicate(licensePlate)) {
            System.out.println("Biển kiểm soát đã tồn tại.");
            return;
        }

        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int productionYear = getIntInput("Năm sản xuất phải là số: ");
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập dung tích xi lanh (cc): ");
        int engineCapacity = getIntInput("Dung tích xi lanh phải là số: ");

        Moto moto = new Moto(engineCapacity, licensePlate, manufacturer, productionYear, owner);
        List<Moto> motos = motoRepository.readFromFile(); 
        motos.add(moto); 
        motoRepository.writeToFile(motos); 
        System.out.println("Thêm xe máy thành công.");
    }

    private int getIntInput(String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print(errorMessage);
            }
        }
    }

    private double getDoubleInput(String errorMessage) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print(errorMessage);
            }
        }
    }

    public void displayVehiclesByType(String type) {
        switch (type) {
            case "Car":
                displayCars();
                break;
            case "Truck":
                displayTrucks();
                break;
            case "Moto":
                displayMotos();
                break;
            default:
                System.out.println("Loại phương tiện không hợp lệ.");
        }
    }

   private void displayCars() {
    List<Car> cars = carRepository.readFromFile(); // Đọc danh sách ô tô
    if (cars.isEmpty()) {
        System.out.println("Không có ô tô nào để hiển thị.");
    } else {
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+----------+%n");
        System.out.printf("| Biển kiểm soát | Nhà sản xuất       | Năm sản xuất    | Chủ sở hữu         | Loại xe         | Số ghế  |%n");
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+----------+%n");
        for (Car car : cars) {
            System.out.printf("| %-15s | %-18s | %-15d | %-18s | %-15s | %-8d |%n", 
                car.getLicensePlate(), 
                car.getManufacturer(), 
                car.getProductionYear(), 
                car.getOwner(), 
                car.getType(), 
                car.getSeats());
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+----------+%n");
    }
}

private void displayTrucks() {
    List<Truck> trucks = truckRepository.readFromFile(); // Đọc danh sách xe tải
    if (trucks.isEmpty()) {
        System.out.println("Không có xe tải nào để hiển thị.");
    } else {
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+%n");
        System.out.printf("| Biển kiểm soát | Nhà sản xuất       | Năm sản xuất    | Chủ sở hữu         | Tải trọng (kg)  |%n");
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+%n");
        for (Truck truck : trucks) {
            System.out.printf("| %-15s | %-18s | %-15d | %-18s | %-15.2f |%n", 
                truck.getLicensePlate(), 
                truck.getManufacturer(), 
                truck.getProductionYear(), 
                truck.getOwner(), 
                truck.getPayload());
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+%n");
    }
}

private void displayMotos() {
    List<Moto> motos = motoRepository.readFromFile(); // Đọc danh sách xe máy
    if (motos.isEmpty()) {
        System.out.println("Không có xe máy nào để hiển thị.");
    } else {
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+%n");
        System.out.printf("| Biển kiểm soát | Nhà sản xuất       | Năm sản xuất    | Chủ sở hữu         | Dung tích (cc)  |%n");
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+%n");
        for (Moto moto : motos) {
            System.out.printf("| %-15s | %-18s | %-15d | %-18s | %-15d |%n", 
                moto.getLicensePlate(), 
                moto.getManufacturer(), 
                moto.getProductionYear(), 
                moto.getOwner(), 
                moto.getEngineCapacity());
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+%n");
    }
}

    public boolean deleteVehicle(String licensePlate) {
        // Xóa xe ô tô
        List<Car> cars = carRepository.readFromFile();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(licensePlate)) {
                cars.remove(i);
                carRepository.writeToFile(cars); 
                return true;
            }
        }

        // Xóa xe tải
        List<Truck> trucks = truckRepository.readFromFile();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlate().equals(licensePlate)) {
                trucks.remove(i);
                truckRepository.writeToFile(trucks); // Ghi lại danh sách xe tải
                return true;
            }
        }

        // Xóa xe máy
        List<Moto> motos = motoRepository.readFromFile();
        for (int i = 0; i < motos.size(); i++) {
            if (motos .get(i).getLicensePlate().equals(licensePlate)) {
                motos.remove(i);
                motoRepository.writeToFile(motos); 
                return true;
            }
        }

        return false; 
    }

    public void confirmDeleteVehicle(String licensePlate) {
        System.out.print("Bạn có chắc chắn muốn xóa phương tiện với biển kiểm soát " + licensePlate + " không? (Yes/No): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            if (deleteVehicle(licensePlate)) {
                System.out.println("Đã xóa thành công! Nhấn Enter để quay lại menu chính.");
                scanner.nextLine(); 
            } else {
                System.out.println("Không tìm thấy phương tiện với biển kiểm soát: " + licensePlate);
            }
        } else if (confirmation.equals("no")) {
            System.out.println("Quay lại menu chính.");
        } else {
            System.out.println("Lựa chọn không hợp lệ. Quay lại menu chính.");
        }
    }
}

