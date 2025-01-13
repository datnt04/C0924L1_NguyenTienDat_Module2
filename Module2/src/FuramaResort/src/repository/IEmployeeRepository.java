/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package repository;

    import java.util.List;
    import model.Employee;

    /**
     *
     * @author ACER
     */
    public interface IEmployeeRepository extends Repository<Employee, List<Employee>> {
            @Override
    List<Employee> readFile(); // Đọc danh sách nhân viên từ file

    @Override
    void writeFile(List<Employee> employees); // Ghi danh sách nhân viên vào file
}
    
