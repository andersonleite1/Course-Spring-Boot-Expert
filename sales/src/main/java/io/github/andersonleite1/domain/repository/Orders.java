package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.Client;
import io.github.andersonleite1.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Orders extends JpaRepository<Order, Integer> {
    List<Order> findByClient(Client client);
}
