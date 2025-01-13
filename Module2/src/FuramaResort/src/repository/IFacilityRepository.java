/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Map;
import model.Facility;

public interface IFacilityRepository extends Repository<Facility, Map<Facility, Integer>> {
    Map<Facility, Integer> readFile();
    void writeFile(Map<Facility, Integer> facilities);
}
