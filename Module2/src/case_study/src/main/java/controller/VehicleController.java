/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import service.VehicleService;
import view.Menu;

/**
 *
 * @author ACER
 */
public class VehicleController extends Menu {

    private static final String[] menuChoices = {
        "Thêm mới phương tiện",
        "Hiển thị phương tiện",
        "Xóa phương tiện",
        "Thoát"
    };

    private final VehicleService vehicleService;

    public VehicleController(String title, String[] mchon) {
        super(title, mchon);
        vehicleService = new VehicleService();
    }

    public static void main(String[] args) {
        VehicleController vehicleController = new VehicleController("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG", menuChoices);
        vehicleController.run();
    }

    @Override
    public void execute(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1: 
                System.out.println("Thêm mới phương tiện:");
                vehicleService.addVehicle();
                System.out.println("Thêm phương tiện thành công! Nhấn Enter để quay lại menu chính.");
                scanner.nextLine(); 
                break;
            case 2: 
                displayVehicleMenu();
                break;
            case 3: 
                System.out.print("Nhập biển kiểm soát cần xóa: ");
                String licensePlate = scanner.nextLine();
                vehicleService.confirmDeleteVehicle(licensePlate); 
                break;
            case 4: 
                System.out.println("Thoát chương trình. Tạm biệt!");
                System.exit(0);
                break;
            default: 
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                break;
        }
    }

    private void displayVehicleMenu() {
        String[] vehicleMenu = {
            "Hiển thị xe tải",
            "Hiển thị ô tô",
            "Hiển thị xe máy",
            "Quay lại"
        };

        Menu vehicleManagement = new Menu("Hiển thị phương tiện", vehicleMenu) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1: 
                        vehicleService.displayVehiclesByType("Truck");
                        break;
                    case 2: 
                        vehicleService.displayVehiclesByType("Car");
                        break;
                    case 3: 
                        vehicleService.displayVehiclesByType("Moto");
                        break;
                    case 4: 
                        System.out.println("Quay lại menu chính.");
                         main(menuChoices) ;
                        break;
                    default: 
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            }
        };
        vehicleManagement.run();
    }
}