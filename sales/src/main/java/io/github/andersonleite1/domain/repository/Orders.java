package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orders extends JpaRepository<Order, Integer> {
}
