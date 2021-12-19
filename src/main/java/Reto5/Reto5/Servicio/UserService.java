/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.Servicio;


import Reto5.Reto5.Modelo.User;
import Reto5.Reto5.Repositorio.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Sanchez
 */
@Service
public class UserService {
      @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        
        return userRepository.getUser(id);
    }

    public User create(User user) {
        if (user.getId() == null) {
            return user;            
        }else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }           
        }
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null){
                   userDb.get().setBirthtDay(user.getBirthtDay());
                }

                if (user.getMonthBirthtDay() != null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
   public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }
   public User authenticateUser(String email, String password){
        Optional<User>user=userRepository.authenticateUser(email, password);
        if (user.isEmpty()){
            return new User();
        }
        return user.get();
    }
   public List<User>getByMonthBirthDay(String monthBirthDay){
        return userRepository.getByMonthBirthtDay(monthBirthDay);
    }
}
