/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Employee;

/**
 *
 * @author ACER
 */
public interface IEmployeeService extends Service<Employee> {

    @Override
    Employee findById(String id); // Tìm nhân viên theo ID

    @Override
    void display(); // Hiển thị danh sách nhân viên

    @Override
    void add(Employee employee); // Thêm mới nhân viên

    @Override
    void save(); // Lưu trữ dữ liệu nhân viên

    @Override
    void update(); // Cập nhật thông tin nhân viên

    // Phương thức thêm mới nhân viên với kiểm tra đầu vào
    void addNewEmployee(); 
}


