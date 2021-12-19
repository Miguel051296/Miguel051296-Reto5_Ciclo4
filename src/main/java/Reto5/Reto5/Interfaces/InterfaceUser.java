/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto5.Reto5.Interfaces;


import Reto5.Reto5.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Miguel Sanchez
 */
public interface InterfaceUser extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User>findByEmailAndPassword(String email, String password);
    Optional<User>findByNameOrEmail(String name, String email);
    List<User>findByMonthBirthtDay(String monthBirthtDay);
}
