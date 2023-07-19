package io.github.andersonleite1.service;

import io.github.andersonleite1.api.dto.OrderDTO;
import io.github.andersonleite1.domain.entity.Order;

public interface OrderService {
    Order save(OrderDTO orderDTO);
}
