/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.Repositorio;


import Reto5.Reto5.Interfaces.InterfaceUser;
import Reto5.Reto5.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Miguel Sanchez
 */
@Repository
public class UserRepository {
       @Autowired
    private InterfaceUser interfaceUser;
     
       public List<User> getAll() {
        return (List<User>) interfaceUser.findAll();
    }

    public Optional<User> getUser(int id) {
        return interfaceUser.findById(id);
    }

    public User save(User user) {
        return interfaceUser.save(user);
    }
    
    public void update(User user) {
        interfaceUser.save(user);
    }
    
    public void delete(User user) {
        interfaceUser.delete(user);
    }

    public boolean emailExists(String email){
        Optional<User> user=interfaceUser.findByEmail(email);
        return user.isPresent();
    }
    public Optional<User>authenticateUser(String email, String password){
        return interfaceUser.findByEmailAndPassword(email, password);
    }
    public List<User>getByMonthBirthtDay(String monthBirthtDay){
       return interfaceUser.findByMonthBirthtDay(monthBirthtDay);
    }
}
