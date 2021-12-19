/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.Repositorio;


import Reto5.Reto5.Interfaces.InterfaceOrder;
import Reto5.Reto5.Modelo.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Miguel Sanchez
 */
@Repository
public class OrderRepository {
    @Autowired
    private InterfaceOrder interfaceOrder;

    public List<Order> getAll() {
        return interfaceOrder.findAll();
    }
    public Optional<Order> getOrder(Integer id){
        return interfaceOrder.findById(id);
    }

    public Order save(Order order) {
        return interfaceOrder.save(order);
    }

    public void update(Order order){
        interfaceOrder.save(order);
    }

    public void delete (Order order){
        interfaceOrder.delete(order);
    }


    public List<Order> getOrderByZone(String zone){
        return interfaceOrder.findBySalesManZone(zone);
    }
    public List<Order>getBySalesManId(Integer id){
        return interfaceOrder.findBySalesManId(id);
    }
    public List<Order>getBySalesManIdAndStatus(Integer id, String status){
        return interfaceOrder.findBySalesManIdAndStatus(id, status);
    }
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }
}
