package io.github.andersonleite1.service.impl;

import io.github.andersonleite1.domain.repository.Orders;
import io.github.andersonleite1.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private Orders ordersRepository;

    public OrderServiceImpl(Orders ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
}
