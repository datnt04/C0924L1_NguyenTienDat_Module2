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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;

/**
 *
 * @author ACER
 */
public class EmployeeRepository implements IEmployeeRepository {
   private static final String EMPLOYEE_FILE_PATH = "D:/Kì 3/FuramaResort/src/data/employee.csv"; 

 private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Employee> readFile() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    Date birthDate = sdf.parse(data[2]);
                    Employee employee = new Employee(data[0], data[1], birthDate, data[3], data[4], 
                            data[5], data[6], data[7], data[8], Double.parseDouble(data[9]));
                    employees.add(employee);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void writeFile(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE_PATH))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + sdf.format(employee.getBirthDate()) + 
                        "," + employee.getGender() + "," + employee.getIdCard() + "," + employee.getPhoneNumber() +
                        "," + employee.getEmail() + "," + employee.getQualification() + "," + employee.getPosition() +
                        "," + employee.getSalary());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 