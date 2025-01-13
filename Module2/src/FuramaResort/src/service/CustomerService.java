    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package service;

import java.text.SimpleDateFormat;
    import java.util.Date;
    import model.Customer;

    /**
     *
     * @author ACER
     */

    import model.Customer;
    import repository.ICustomerRepository;
    import repository.CustomerRepository;

    import java.util.List;
    import java.util.Scanner;
import utils.CustomerValidation;
    import utils.Validation;

    public class CustomerService implements ICustomerService {

         private final CustomerRepository customerRepository = new CustomerRepository();
    private final Scanner scanner = new Scanner(System.in);
 private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Customer findById(String id) {
        List<Customer> customers = customerRepository.readFile();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void display() {
          List<Customer> customers = customerRepository.readFile(); // Đọc danh sách khách hàng
        if (customers.isEmpty()) {
            System.out.println("No customers found."); // Kiểm tra xem danh sách có rỗng không
            return;
        }

        // In tiêu đề bảng
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", 
                          "Customer ID", "Name", "Birth Date", "Gender", "ID Card", "Phone Number", "Email", "Customer Type", "Address");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        // Duyệt qua danh sách khách hàng và in thông tin
        for (Customer customer : customers) {
            System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", 
                              customer.getId(), 
                              customer.getName(), 
                              dateFormat.format(customer.getBirthDate()), 
                              customer.getGender(), 
                              customer.getIdCard(), 
                              customer.getPhoneNumber(), 
                              customer.getEmail(), 
                              customer.getCustomerType(), 
                              customer.getAddress()); // Hiển thị địa chỉ
        }
    }
    @Override
    public void add(Customer customer) {
        List<Customer> customers = customerRepository.readFile();
        customers.add(customer);
        customerRepository.writeFile(customers);
        System.out.println("Customer added successfully.");
    }

    @Override
    public void save() {
        List<Customer> customers = customerRepository.readFile();
        customerRepository.writeFile(customers);
        System.out.println("Customers saved successfully.");
    }

    @Override
    public void update() {
         System.out.print("Enter Customer ID to edit: ");
    String id = scanner.nextLine();

    Customer customer = findById(id);
    if (customer == null) {
        System.out.println("Customer not found.");
        return;
    }

    System.out.println("Editing customer: " + customer.getName());

    System.out.print("Enter new name (or press Enter to keep '" + customer.getName() + "'): ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        customer.setName(CustomerValidation.checkName("Enter valid name: "));
    }

    System.out.print("Enter new birth date (dd/MM/yyyy) (or press Enter to keep '" + customer.getBirthDate() + "'): ");
    String newBirthDateStr = scanner.nextLine();
    if (!newBirthDateStr.isEmpty()) {
        customer.setBirthDate(CustomerValidation.checkBirthDate("Enter valid birth date (dd/MM/yyyy): "));
    }

    System.out.print("Enter new gender (or press Enter to keep '" + customer.getGender() + "'): ");
    String newGender = scanner.nextLine();
    if (!newGender.isEmpty()) {
        customer.setGender(CustomerValidation.checkInputGender("Enter valid gender (Nam, Nữ, Khác): ", newGender));
    }

    System.out.print("Enter new ID card (or press Enter to keep '" + customer.getIdCard() + "'): ");
    String newIdCard = scanner.nextLine();
    if (!newIdCard.isEmpty()) {
        customer.setIdCard(CustomerValidation.checkIdCard("Enter valid ID card number: "));
    }

    System.out.print("Enter new phone number (or press Enter to keep '" + customer.getPhoneNumber() + "'): ");
    String newPhoneNumber = scanner.nextLine();
    if (!newPhoneNumber.isEmpty()) {
        customer.setPhoneNumber(CustomerValidation.checkPhoneNumber("Enter valid phone number: "));
    }

    System.out.print("Enter new email (or press Enter to keep '" + customer.getEmail() + "'): ");
    String newEmail = scanner.nextLine();
    if (!newEmail.isEmpty()) {
        customer.setEmail(CustomerValidation.checkInputEmail("Enter valid email: ", newEmail));
    }

    System.out.print("Enter new customer type (or press Enter to keep '" + customer.getCustomerType() + "'): ");
    String newCustomerType = scanner.nextLine();
    if (!newCustomerType.isEmpty()) {
        customer.setCustomerType(CustomerValidation.checkInputMembershipLevel("Enter valid customer type: ", newCustomerType));
    }

    System.out.print("Enter new address (or press Enter to keep '" + customer.getAddress() + "'): ");
    String newAddress = scanner.nextLine();
    if (!newAddress.isEmpty()) {
        customer.setAddress(newAddress);
    }

    save();
    System.out.println("Customer updated successfully.");
}

   public void addNewCustomer() {
 String customerId;
    while (true) {
        customerId = CustomerValidation.checkCustomerId("Enter customer ID (format: KH-YYYY): ");
        if (findById(customerId) != null) { 
            System.out.println("Customer ID already exists. Please enter a unique ID.");
        } else {
            break; 
        }
    }

    String name = CustomerValidation.checkName("Enter customer name: ");
    Date birthDate = CustomerValidation.checkBirthDate("Enter customer birth date (dd/MM/yyyy): ");
    String gender = CustomerValidation.checkInputGender("Enter customer gender: ", "Gender");
    String idCard = CustomerValidation.checkIdCard("Enter customer ID Card: ");
    String phoneNumber = CustomerValidation.checkPhoneNumber("Enter customer phone number: ");
    String email = CustomerValidation.checkInputEmail("Enter customer email: ", "Email"); 
    String customerType = CustomerValidation.checkInputMembershipLevel("Enter customer type: ", "Customer Type");
    String address = CustomerValidation.checkNotEmpty("Enter customer address: ", "Address");

    Customer newCustomer = new Customer(customerId, name, birthDate, gender, idCard, phoneNumber, email, customerType, address);
    add(newCustomer); 
}
    }