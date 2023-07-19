package io.github.andersonleite1;

import io.github.andersonleite1.domain.entity.Client;
import io.github.andersonleite1.domain.entity.Order;
import io.github.andersonleite1.domain.repository.Clients;
import io.github.andersonleite1.domain.repository.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clients clients, @Autowired Orders orders) {
        return args -> {
            System.out.println("Salvando Clientes");
            Client client1 = new Client(null, "Jao");
            clients.save(client1);

            Order order = new Order();
            order.setClient(client1);
            order.setDateOrder(LocalDate.now());
            order.setTotal(BigDecimal.valueOf(100));
            orders.save(order);

            Client c = clients.findClientFetchOrders(client1.getId());
            System.out.println(c);
            System.out.println(c.getOrders());
//            orders.findByClient(client1).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
