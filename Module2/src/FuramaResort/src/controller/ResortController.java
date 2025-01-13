/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
import java.util.Scanner;
import model.Employee;
import service.BookingService;
import service.ContractService;
import service.CustomerService;
import service.EmployeeService;
import service.FacilityService;
import service.PromotionService;
import view.Menu;

public class ResortController extends Menu {

    static String[] menuChoices = {"Employee Management","Customer Management","Facility Management","Booking Management","Promotion Management","Quit"
    };

    public ResortController(String title, String[] mchon) {
        super(title, mchon);
    }

    public static void main(String[] args) {
        ResortController resortController = new ResortController("Resort Management", menuChoices);
        resortController.run();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                employeeManagement();
                break;
            case 2:
                customerManagement();
                break;
            case 3:
                facilityManagement();
                break;
            case 4:
                bookingManagement();
                break;
            case 5:
                promotionManagement();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    private void employeeManagement() {
        String[] empMenu = {"Display all employees", "Add new employee", "Edit employee", "Return"};
        Menu empManagement = new Menu("Employee Management", empMenu) {
            @Override
            public void execute(int ch) {
                EmployeeService employeeService = new EmployeeService(); 
                 Scanner scanner = new Scanner(System.in);
                switch (ch) {
                    case 1:
                        System.out.println("Displaying all employees");
                        employeeService.display();
                        break;
                    case 2:
                        System.out.println("Adding new employee");
                      employeeService.addNewEmployee();
                        break;
                    case 3:
                    

                    employeeService.update();
                  
                    break;
                    case 4:
                        main(menuChoices) ;
                }
            }
        };
        empManagement.run();
    }

    private void customerManagement() {
        String[] custMenu = {"Display all customers", "Add new customer", "Edit customer", "Return"};
        Menu custManagement = new Menu("Customer Management", custMenu) {
             CustomerService customerService = new CustomerService(); 
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        System.out.println("Displaying all customers");
                       customerService.display();
                        break;
                    case 2:
                        System.out.println("Adding new customer");
                        customerService.addNewCustomer();
                        break;
                    case 3:
                        System.out.println("Editing customer");
                       customerService.update();
                        break;
                    case 4:
                        main(menuChoices);
                        
                }
            }
        };
        custManagement.run();
    }

private void facilityManagement() {
    String[] facMenu = {"Display all facilities", "Add new facility", "Display facility maintenance", "Return"};
    Menu facManagement = new Menu("Facility Management", facMenu) {
        FacilityService facilityService = new FacilityService();  

        @Override
        public void execute(int ch) {
            switch (ch) {
                case 1:
                    System.out.println("Displaying all facilities");
                    facilityService.display(); 
                    break;
                    
                case 2:
                    System.out.println("Adding new facility");
                    facilityService.addNewFacility();  
                    break;
                    
                case 3:
                    System.out.println("Displaying facility maintenance");
                    facilityService.displayMaintenanceFacilities(); 
                    break;
                    
                    
                case 4:
                    main(menuChoices);  
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    };
    facManagement.run();  
}

    private void bookingManagement() {
        String[] bookMenu = {"Add new booking", "Display all bookings", "Create new contracts", "Display contracts", "Edit contracts", "Return"};
        Menu bookManagement = new Menu("Booking Management", bookMenu) {
            BookingService bookingService = new BookingService();  
        ContractService contractService = new ContractService();
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        System.out.println("Adding new booking");
                        bookingService.addBooking();
                        break;
                    case 2:
                        System.out.println("Displaying all bookings");
                        bookingService.displayBookings();
                        break;
                    case 3:
                            
                        System.out.println("Creating new contracts");
                     contractService.initBookingQueue();
                      contractService.createContractFromEarliestBooking();
                        break;
                    case 4:
                        System.out.println("Displaying contracts");
                        contractService.displayAllContracts();
                        break;
                    case 5:
                        System.out.println("Editing contracts");
                        contractService.updateContract();
                        break;
                    case 6:
                        main(menuChoices);
                }
            }
        };
        bookManagement.run();
    }

    private void promotionManagement() {
        String[] promoMenu = {"Display customers using service", "Display customers receiving vouchers", "Return"};
        Menu promoManagement = new Menu("Promotion Management", promoMenu) {
            PromotionService  promotionService = new PromotionService();
             private final Scanner scanner = new Scanner(System.in);
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        System.out.println("Displaying customers using service..."); 
                        promotionService.display(); 
                        break;
                    case 2:
                        System.out.println("Displaying customers receiving vouchers...");
                        promotionService.displayHaveDiscount();
                        break;
                    case 3:
                        main(menuChoices); 
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        promoManagement.run();
    }
}