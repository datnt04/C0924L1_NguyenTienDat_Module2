/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import repository.EmployeeRepository;
import utils.EmployeeValidation;
import utils.Validation;

/**
 *
 * @author ACER
 */

public class EmployeeService implements IEmployeeService {
  private EmployeeRepository employeeRepository = new EmployeeRepository();
    private Scanner scanner = new Scanner(System.in);
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public Employee findById(String id) {
        List<Employee> employees = employeeRepository.readFile();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void display() {
         List<Employee> employees = employeeRepository.readFile();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-25s | %-15s | %-15s |\n", 
                      "Employee ID", "Name", "Birth Date", "Gender", "ID Card", "Phone Number", "Email", "Qualification", "Position");
    System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    for (Employee employee : employees) {
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-25s | %-15s | %-15s |\n", 
                          employee.getId(),
                          employee.getName(), 
                          dateFormat.format(employee.getBirthDate()), 
                          employee.getGender(), 
                          employee.getIdCard(), 
                          employee.getPhoneNumber(), 
                          employee.getEmail() != null ? employee.getEmail() : "N/A", // Handle null email
                          employee.getQualification() != null ? employee.getQualification() : "N/A", // Handle null qualification
                          employee.getPosition() != null ? employee.getPosition() : "N/A"); // Handle null position
    }
}

    @Override
    public void add(Employee employee) {
        List<Employee> employees = employeeRepository.readFile();
        employees.add(employee);
        employeeRepository.writeFile(employees);
        System.out.println("Employee added successfully.");
    }

    @Override
    public void save() {
        List<Employee> employees = employeeRepository.readFile();
        employeeRepository.writeFile(employees);
        System.out.println("Employees saved successfully.");
    }

    @Override
    public void update() {
       
       System.out.print("Enter Employee ID to edit: ");
    String id = scanner.nextLine();

    // Tìm kiếm nhân viên bằng ID
    Employee employee = findById(id);
    if (employee == null) {
        System.out.println("Employee not found.");
        return;
    }

    System.out.println("Editing employee: " + employee.getName());

    // Cập nhật tên
    System.out.print("Enter new name (or press Enter to keep '" + employee.getName() + "'): ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        employee.setName(EmployeeValidation.checkName("Enter valid name: "));
    }

    // Cập nhật ngày sinh
    System.out.print("Enter new birth date (dd/MM/yyyy) (or press Enter to keep '" + employee.getBirthDate() + "'): ");
    String newBirthDateStr = scanner.nextLine();
    if (!newBirthDateStr.isEmpty()) {
        employee.setBirthDate(EmployeeValidation.checkBirthDate("Enter valid birth date (dd/MM/yyyy): "));
    }

    // Cập nhật giới tính
    System.out.print("Enter new gender (or press Enter to keep '" + employee.getGender() + "'): ");
    String newGender = scanner.nextLine();
    if (!newGender.isEmpty()) {
        employee.setGender(EmployeeValidation.checkInputGender("Enter valid gender (Nam, Nữ, Khác): ", newGender));
    }

    // Cập nhật ID Card
    System.out.print("Enter new ID card (or press Enter to keep '" + employee.getIdCard() + "'): ");
    String newIdCard = scanner.nextLine();
    if (!newIdCard.isEmpty()) {
        employee.setIdCard(EmployeeValidation.checkIdCard("Enter valid ID card number: "));
    }

    // Cập nhật số điện thoại
    System.out.print("Enter new phone number (or press Enter to keep '" + employee.getPhoneNumber() + "'): ");
    String newPhoneNumber = scanner.nextLine();
    if (!newPhoneNumber.isEmpty()) {
        employee.setPhoneNumber(EmployeeValidation.checkPhoneNumber("Enter valid phone number: "));
    }

    // Cập nhật email
    System.out.print("Enter new email (or press Enter to keep '" + employee.getEmail() + "'): ");
    String newEmail = scanner.nextLine();
    if (!newEmail.isEmpty()) {
    employee.setEmail(EmployeeValidation.checkInputEmail("Enter valid email: "));
    }

    // Cập nhật trình độ học vấn
     System.out.print("Enter new qualification (or press Enter to keep '" + employee.getQualification() + "'): ");
    String newQualification = scanner.nextLine();
    if (!newQualification.isEmpty()) {
        employee.setQualification(newQualification);
    }

    // Cập nhật vị trí công việc
    System.out.print("Enter new position (or press Enter to keep '" + employee.getPosition() + "'): ");
    String newPosition = scanner.nextLine();
    if (!newPosition.isEmpty()) {
        employee.setPosition(EmployeeValidation.checkInputPosition("Enter valid position: ", newPosition));
    }

    // Cập nhật mức lương
    System.out.print("Enter new salary (or press Enter to keep '" + employee.getSalary() + "'): ");
    String newSalaryStr = scanner.nextLine();
    if (!newSalaryStr.isEmpty()) {
        double newSalary = EmployeeValidation.checkSalary("Enter valid salary: ");
        employee.setSalary(newSalary);
    }

    // Lưu danh sách nhân viên sau khi cập nhật
    save();
    System.out.println("Employee updated successfully.");
}

    @Override
    public void addNewEmployee() {
         String employeeId;
      while (true) {
        employeeId = EmployeeValidation.checkEmployeeId("Enter employee ID (format: NV-YYYY): ");
        if (findById(employeeId) != null) {
            System.out.println("Employee ID already exists. Please enter a unique ID.");
        } else {
            break; 
        }
    }

    String name = EmployeeValidation.checkName("Enter employee name: ");
    Date birthDate = EmployeeValidation.checkBirthDate("Enter employee birth date (dd/MM/yyyy): ");
    String gender = EmployeeValidation.checkInputGender("Enter employee gender: ", "Gender");
    String idCard = EmployeeValidation.checkIdCard("Enter employee ID Card: ");
    String phoneNumber = EmployeeValidation.checkPhoneNumber("Enter employee phone number: ");
    String email = EmployeeValidation.checkInputEmail("Enter employee email: ");
    String educationLevel = EmployeeValidation.checkNotEmpty("Enter employee education level: ", "Education level");
    String position = EmployeeValidation.checkInputPosition("Enter employee position: ", "Position");
    double salary = EmployeeValidation.checkSalary("Enter employee salary: ");

    Employee newEmployee = new Employee(employeeId, name, birthDate, gender, idCard, phoneNumber, email, educationLevel, position, salary);
    add(newEmployee);
    save();
}
}