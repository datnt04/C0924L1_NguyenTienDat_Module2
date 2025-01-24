/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.ContactService;
import view.Menu;

/**
 *
 * @author ACER
 */
public class ContactController {
    private final ContactService contactService;

    public ContactController() {
        this.contactService = new ContactService();
    }

    public void run() {
        String[] menuOptions = {
            "Xem danh sách",
            "Thêm mới",
            "Cập nhật",
            "Xóa",
            "Tìm kiếm",
            "Đọc từ file",
            "Lưu vào file",
            "Thoát"
        };

        Menu menu = new Menu("QUẢN LÝ DANH BẠ", menuOptions);

        while (true) {
            menu.display();
            int choice = menu.getChoice();
            execute(choice);
        }
    }

    private void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Danh sách từ bộ nhớ");
                contactService.displayContacts(); 
                
                break;
            case 2:
                contactService.addContact(); 
                break;
            case 3:
                contactService.updateContact(); 
                break;
            case 4:
                contactService.deleteContact(); 
                break;
            case 5:
                contactService.searchContact();
                break;
            case 6:
                System.out.println("danh sách từ file:");
                contactService.displayContactsFromFile();                break;
            case 7:
                  contactService.saveContactsToFile();
                break;
            case 8:
                System.out.println("Thoát chương trình.");
                System.exit(0);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    public static void main(String[] args) {
        ContactController contactController = new ContactController();
        contactController.run();
    }
}