/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto5.Reto5.Interfaces;


import Reto5.Reto5.Modelo.Supplements;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Miguel Sanchez
 */
public interface InterfaceSupplements extends MongoRepository<Supplements, String>{
    public List<Supplements>findByPrice(double price);
    public List<Supplements>findByDescriptionContainingIgnoreCase(String description);
}
