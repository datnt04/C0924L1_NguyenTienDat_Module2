/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author ACER
 */
public class ContactRepository implements IContactRepository {

    @Override
    public List<Contact> readFromFile() {
        List<Contact> contacts = new ArrayList<>();
        String line;
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); 
                if (values.length == 7) { 
                    Contact contact = new Contact(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                    contacts.add(contact); 
                }
            }
            System.out.println("Successful");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return contacts; 
    }

    @Override
    public void writeToFile(List<Contact> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String header = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email";
            bw.write(header);
            bw.newLine();

            for (Contact contact : contacts) {
                bw.write(contact.toString());
                bw.newLine();
            }
            System.out.println("Đã lưu danh bạ vào file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }
}
    

