/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import repository.FacilityRepository;
import utils.FacilityValidation;
import utils.Validation;

public class FacilityService implements IFacilityService {
    private FacilityRepository facilityRepository = new FacilityRepository();
    private Scanner scanner = new Scanner(System.in);

     @Override
    public void add(Facility facility) {
        facilityRepository.add(facility); // Gọi phương thức add từ FacilityRepository
        System.out.println("Cơ sở vật chất đã được thêm thành công.");
    }

    public void addNewFacility() {
        System.out.println("Chọn loại cơ sở vật chất cần thêm:");
        System.out.println("1. Thêm Villa");
        System.out.println("2. Thêm House");
        System.out.println("3. Thêm Room");

        int choice = Validation.checkInputInt("Nhập lựa chọn của bạn: ");
        switch (choice) {
            case 1:
                addVilla();
                break;
            case 2:
                addHouse();
                break;
            case 3:
                addRoom();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void addVilla() {
        String serviceCode;
    while (true) {
        serviceCode = FacilityValidation.checkInputServiceCode("Nhập mã dịch vụ: ");
        if (findById(serviceCode) != null) { 
            System.out.println("Mã dịch vụ đã tồn tại. Vui lòng nhập mã khác.");
        } else {
            break; 
        }
    }

    String serviceName = FacilityValidation.checkInputString("Nhập tên dịch vụ: ");
    double area = FacilityValidation.checkInputDouble("Nhập diện tích: ");
    double rentalCost = FacilityValidation.checkInputDouble("Nhập chi phí thuê: ");
    int maxPeople = FacilityValidation.checkInputInt("Nhập số lượng người tối đa: ");
    String rentalType = FacilityValidation.checkInputString("Nhập kiểu thuê: ");
    String roomStandard = FacilityValidation.checkInputString("Nhập tiêu chuẩn phòng: ");
    double poolArea = FacilityValidation.checkInputDouble("Nhập diện tích hồ bơi: ");
    int numberOfFloors = FacilityValidation.checkInputInt("Nhập số tầng: ");

    Facility villa = new Villa(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType, roomStandard, poolArea, numberOfFloors);
    add(villa);
}

    private void addHouse() {
         String serviceCode;
    while (true) {
        serviceCode = FacilityValidation.checkInputServiceCode("Nhập mã dịch vụ: ");
        if (findById(serviceCode) != null) { 
            System.out.println("Mã dịch vụ đã tồn tại. Vui lòng nhập mã khác.");
        } else {
            break; 
        }
    }

    String serviceName = FacilityValidation.checkInputString("Nhập tên dịch vụ: ");
    double area = FacilityValidation.checkInputDouble("Nhập diện tích: ");
    double rentalCost = FacilityValidation.checkInputDouble("Nhập chi phí thuê: ");
    int maxPeople = FacilityValidation.checkInputInt("Nhập số lượng người tối đa: ");
    String rentalType = FacilityValidation.checkInputString("Nhập kiểu thuê: ");
    String roomStandard = FacilityValidation.checkInputString("Nhập tiêu chuẩn phòng: ");
    int numberOfFloors = FacilityValidation.checkInputInt("Nhập số tầng: ");

    Facility house = new House(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType, roomStandard, numberOfFloors);
    add(house); 
}
    private void addRoom() {
        String serviceCode;
    while (true) {
        serviceCode = FacilityValidation.checkInputServiceCode("Nhập mã dịch vụ: ");
        if (findById(serviceCode) != null) { 
            System.out.println("Mã dịch vụ đã tồn tại. Vui lòng nhập mã khác.");
        } else {
            break; 
        }
    }

    String serviceName = FacilityValidation.checkInputString("Nhập tên dịch vụ: ");
    double area = FacilityValidation.checkInputDouble("Nhập diện tích: ");
    double rentalCost = FacilityValidation.checkInputDouble("Nhập chi phí thuê: ");
    int maxPeople = FacilityValidation.checkInputInt("Nhập số lượng người tối đa: ");
    String rentalType = FacilityValidation.checkInputString("Nhập kiểu thuê: ");
    String freeService = FacilityValidation.checkInputString("Nhập dịch vụ miễn phí đi kèm: ");

    Facility room = new Room(serviceCode, serviceName, area, rentalCost, maxPeople, rentalType, freeService);
    add(room); 
    }

    @Override
    public void display() {
        Map<Facility, Integer> facilities = facilityRepository.readFile();
        if (facilities.isEmpty()) {
            System.out.println("Không có cơ sở vật chất nào.");
        } else {
            facilities.forEach((facility, usageCount) -> 
                System.out.println(facility.toString() + ", Số lần sử dụng: " + usageCount)
            );
        }
    }

    @Override
    public Facility findById(String id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save() {
        Map<Facility, Integer> facilities = facilityRepository.readFile();
        facilityRepository.writeFile(facilities);
        System.out.println("Lưu thành công.");
    }

    @Override
    public void update() {
        System.out.print("Nhập mã dịch vụ bạn muốn cập nhật: ");
        String serviceCode = scanner.nextLine();

        Facility facilityToUpdate = findById(serviceCode);

        if (facilityToUpdate == null) {
            System.out.println("Không tìm thấy mã dịch vụ: " + serviceCode);
            return;
        }

        System.out.println("Cập nhật thông tin cho: " + facilityToUpdate.getServiceName());

        String newServiceName = FacilityValidation.checkInputString("Nhập tên dịch vụ mới: ");
        facilityToUpdate.setServiceName(newServiceName);

        double newArea = FacilityValidation.checkInputDouble("Nhập diện tích mới: ");
        facilityToUpdate.setArea(newArea);

        double newRentalCost = FacilityValidation.checkInputDouble("Nhập chi phí thuê mới: ");
        facilityToUpdate.setRentalCost(newRentalCost);

        int newMaxPeople = FacilityValidation.checkInputInt("Nhập số lượng người tối đa: ");
        facilityToUpdate.setMaxPeople(newMaxPeople);

        String newRentalType = FacilityValidation.checkInputString("Nhập kiểu thuê mới: ");
        facilityToUpdate.setRentalType(newRentalType);

        facilityRepository.writeFile(facilityRepository.readFile());
        System.out.println("Cập nhật thành công.");
    }

    @Override
    public void displayMaintenanceFacilities() {
        Map<Facility, Integer> facilityUsageMap = facilityRepository.readFile();
        boolean hasMaintenanceFacilities = false;

        System.out.println("Danh sách cơ sở vật chất cần bảo trì (sử dụng trên 5 lần):");
        for (Map.Entry<Facility, Integer> entry : facilityUsageMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey().getServiceName() + " - Số lần sử dụng: " + entry.getValue());
                hasMaintenanceFacilities = true;
            }
        }

        if (!hasMaintenanceFacilities) {
            System.out.println("Không có cơ sở nào cần bảo trì.");
        }
    }
}