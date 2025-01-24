/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Respository.ContactRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Contact;
import utils.Validation;

/**
 *
 * @author ACER
 */
public class ContactService {
    private List<Contact> contacts; 
     private ContactRepository contactRepository = new ContactRepository();
    public ContactService() {
        this.contacts = new ArrayList<>(); 
        
    }
//them
    public void addContact() {
        Scanner scanner = new Scanner(System.in);

        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            if (Validation.isValidPhoneNumber(phoneNumber)) {
                break; 
            } else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập nhóm: ");
        String group = scanner.nextLine();

        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        
        System.out.print("Nhập ngày sinh: ");
        String birthDate = scanner.nextLine();    
       
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (Validation.isValidEmail(email)) {
                break; 
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        }

       
        Contact contact = new Contact(phoneNumber, group, name, gender, address, null, email); // Chưa xử lý ngày sinh
        contacts.add(contact);
        System.out.println("Thêm danh bạ thành công!");
    }
    //díplay
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+-----------------+%n");
        System.out.printf("| Số điện thoại   | Nhóm               | Họ tên          | Giới tính          | Địa chỉ         | Email           |%n");
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+-----------------+%n");
        for (Contact contact : contacts) {
            System.out.printf("| %-15s | %-18s | %-15s | %-18s | %-15s | %-15s |%n",
                    contact.getPhoneNumber(),
                    contact.getGroup(),
                    contact.getName(),
                    contact.getGender(),
                    contact.getAddress(),
                    contact.getEmail());
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+-----------------+%n");
    }
    // update
    public void updateContact() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập số điện thoại của danh bạ cần sửa: ");
    String phoneNumber = scanner.nextLine();

    Contact contactToUpdate = null;
    for (Contact contact : contacts) {
        if (contact.getPhoneNumber().equals(phoneNumber)) {
            contactToUpdate = contact;
            break;
        }
    }

    if (contactToUpdate == null) {
        System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
        return;
    }

    System.out.println("Thông tin hiện tại ");
    System.out.println(contactToUpdate);

    System.out.print("Nhập nhóm mới: ");
    String newGroup = scanner.nextLine();
    contactToUpdate.setGroup(newGroup);

    System.out.print("Nhập họ tên mới: ");
    String newName = scanner.nextLine();
    contactToUpdate.setName(newName);

    System.out.print("Nhập giới tính mới: ");
    String newGender = scanner.nextLine();
    contactToUpdate.setGender(newGender);

    System.out.print("Nhập địa chỉ mới: ");
    String newAddress = scanner.nextLine();
    contactToUpdate.setAddress(newAddress);

    
    System.out.print("Nhập ngày sinh mới: ");
    String newBirthDate = scanner.nextLine();
    contactToUpdate.setBirthDate(newBirthDate);

    String newEmail; 
    while (true) {
        System.out.print("Nhập email mới: ");
        newEmail = scanner.nextLine();
        if (Validation.isValidEmail(newEmail)) {
            contactToUpdate.setEmail(newEmail);
            break; 
        } else {
            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
        }
    }
    System.out.println("Cập nhật danh bạ thành công!");
}
    //xóa
    public void deleteContact() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập số điện thoại của danh bạ cần xóa: ");
    String phoneNumber = scanner.nextLine();

    Contact contactToDelete = null;
    for (Contact contact : contacts) {
        if (contact.getPhoneNumber().equals(phoneNumber)) {
            contactToDelete = contact; 
            break; 
        }
    }

    if (contactToDelete == null) {
        System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
        return; 
    }

    System.out.print("Bạn có chắc chắn muốn xóa danh bạ này? (Y/N): ");
    String confirmation = scanner.nextLine();
    if (confirmation.equalsIgnoreCase("Y")) {
        contacts.remove(contactToDelete); 
        System.out.println("Đã xóa danh bạ thành công!");
    } else {
        System.out.println("Hủy bỏ xóa danh bạ.");
    }
}
    // search
    public void searchContact() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập số điện thoại hoặc họ tên của danh bạ cần tìm: ");
    String search = scanner.nextLine();

    boolean found = false; 

    for (Contact contact : contacts) {
        if (contact.getPhoneNumber().equals(search) || contact.getName().equalsIgnoreCase(search)) {
            System.out.println("Danh bạ tìm thấy:");
            System.out.println(contact);
            found = true; 
            break;
        }
    }

    if (!found) {
        System.out.println("Không tìm thấk " + search);
    }
}
     //cn7 
     public void saveContactsToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bạn có muốn lưu danh bạn vào file(y/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equals("y")) { 
            contactRepository.writeToFile(contacts); 
            System.out.println("Danh bạ đã được lưu vào file thành công!");
        } else {
            System.out.println("Hủy bỏ lưu danh bạ.");
        }
    }
      public void displayContactsFromFile() {
        List<Contact> contactsFromFile = contactRepository.readFromFile(); 

        if (contactsFromFile.isEmpty()) {
            System.out.println("Danh bạ trong file trống.");
            return;
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+-----------------+%n");
        System.out.printf("| Số điện thoại   | Nhóm               | Họ tên          | Giới tính          | Địa chỉ         | Email           |%n");
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+-----------------+%n");
        for (Contact contact : contactsFromFile) {
            System.out.printf("| %-15s | %-18s | %-15s | %-18s | %-15s | %-15s |%n",
                    contact.getPhoneNumber(),
                    contact.getGroup(),
                    contact.getName(),
                    contact.getGender(),
                    contact.getAddress(),
                    contact.getEmail());
        }
        System.out.printf("+-----------------+--------------------+-----------------+--------------------+-----------------+-----------------+%n");
    }
}



