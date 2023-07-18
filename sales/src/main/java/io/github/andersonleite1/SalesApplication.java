package io.github.andersonleite1;

import io.github.andersonleite1.domain.entity.Client;
import io.github.andersonleite1.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clients clients) {
        return args -> {
            System.out.println("Salvando Clientes");
            clients.save(new Client(null, "Jao"));
            clients.save(new Client(null, "Ana"));

            List<Client> clientList = clients.findAll();
            clientList.forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            clientList.forEach(client -> {
                client.setNome(client.getName() + " Atualizado");
                clients.save(client);
            });
            clientList.forEach(System.out::println);

            System.out.println("Buscando Clientes com 'J'");
            clients.findByNameLike("J").forEach(System.out::println);

            System.out.println("Deletando Clientes");
            clients.findAll().forEach(client -> {
                clients.delete(client);
            });

            if(clients.findAll().isEmpty()) {
                System.out.println("Nenhum cliente encontrado");
            } else {
                clientList.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
