package io.github.andersonleite1.api.controller;

import io.github.andersonleite1.api.dto.OrderDTO;
import io.github.andersonleite1.domain.entity.Order;
import io.github.andersonleite1.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer create(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.save(orderDTO);
        return order.getId();
    }
}
