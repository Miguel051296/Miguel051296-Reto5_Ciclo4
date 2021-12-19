/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.Repositorio;


import Reto5.Reto5.Interfaces.InterfaceSupplements;
import Reto5.Reto5.Modelo.Supplements;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Sanchez
 */
@Repository
public class SupplementsRepository {
     @Autowired
    private InterfaceSupplements interfaceSupplements;

    public List<Supplements> getAll() {
        return interfaceSupplements.findAll();
    }

    public Optional<Supplements> getSupplements(String reference) {
        return interfaceSupplements.findById(reference);
    }
    public Supplements create(Supplements supplements) {
        return interfaceSupplements.save(supplements);
    }

    public void update(Supplements supplements) {
        interfaceSupplements.save(supplements);
    }
    
    public void delete(Supplements supplements) {
        interfaceSupplements.delete(supplements);
    }
    public List<Supplements>getByPrice(double price){
       return interfaceSupplements.findByPrice(price);
    }

    public List<Supplements>getByDescriptionContainingIgnoreCase(String description){
        return interfaceSupplements.findByDescriptionContainingIgnoreCase(description);
    }
}
