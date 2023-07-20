package io.github.andersonleite1.service;

import io.github.andersonleite1.api.dto.OrderDTO;
import io.github.andersonleite1.domain.entity.Order;
import io.github.andersonleite1.enums.OrderStatus;

import java.util.Optional;

public interface OrderService {
    Order save(OrderDTO orderDTO);
    Optional<Order> getOrderFull(Integer id);
    void updateStatus(Integer id, OrderStatus status);
}
