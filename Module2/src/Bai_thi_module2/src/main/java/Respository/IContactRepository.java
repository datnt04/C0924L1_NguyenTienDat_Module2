/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respository;

/**
 *
 * @author ACER
 */
import model.Contact;

public interface IContactRepository extends Repository<Contact> {
    String FILE_PATH = "src/main/java/data/contacts.csv";
    // e dùng data/contacts.csv nó không chạy được. 
}
