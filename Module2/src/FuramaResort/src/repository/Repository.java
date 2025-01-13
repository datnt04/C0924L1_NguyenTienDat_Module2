/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;

/**
 *
 * @author ACER
 */
public interface Repository<T, C> {
    final String path = new File("src").getAbsolutePath();

    C readFile(); 
    void writeFile(C entities);
}
