package Reto5.Reto5;


import Reto5.Reto5.Interfaces.InterfaceOrder;
import Reto5.Reto5.Interfaces.InterfaceSupplements;
import Reto5.Reto5.Interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto5Application implements CommandLineRunner{

    @Autowired
    private InterfaceSupplements supplementsRepository;

    @Autowired
    private InterfaceUser userRepository;

    @Autowired
    private InterfaceOrder orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto5Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        supplementsRepository.deleteAll();
        orderRepository.deleteAll();
    }
}
