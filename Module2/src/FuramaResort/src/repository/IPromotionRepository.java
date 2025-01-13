/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Stack;
import java.util.TreeSet;
import model.Customer;
import model.Promotion;

/**
 *
 * @author ACER
 */
public interface IPromotionRepository extends Repository<Promotion, TreeSet<Promotion>> {
    String PATH = "src/data/Promotion.csv";

    @Override
    TreeSet<Promotion> readFile();

    @Override
    void writeFile(TreeSet<Promotion> promotions);
}
