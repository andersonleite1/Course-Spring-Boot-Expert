package io.github.andersonleite1.api.controller;

import io.github.andersonleite1.api.dto.InformationOrderItemDTO;
import io.github.andersonleite1.api.dto.InformationOrdersDTO;
import io.github.andersonleite1.api.dto.OrderDTO;
import io.github.andersonleite1.api.dto.UpdateStatusOrderDTO;
import io.github.andersonleite1.domain.entity.ItemOrder;
import io.github.andersonleite1.domain.entity.Order;
import io.github.andersonleite1.enums.OrderStatus;
import io.github.andersonleite1.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("{id}")
    public InformationOrdersDTO getById(@PathVariable Integer id) {
        return orderService
                .getOrderFull(id)
                .map(o -> convert(o))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Order not found"));
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Integer id , @RequestBody UpdateStatusOrderDTO dto){
        String newStatus = dto.getNewStatus();
        orderService.updateStatus(id, OrderStatus.valueOf(newStatus));
    }

    private InformationOrdersDTO convert(Order order) {
        return InformationOrdersDTO
                .builder()
                .code(order.getId())
                .dateOrder(order.getDateOrder().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(order.getClient().getCpf())
                .clientName(order.getClient().getName())
                .total(order.getTotal())
                .status(order.getStatus().name())
                .items(convert(order.getItems()))
                .build();
    }

    private List<InformationOrderItemDTO> convert(List<ItemOrder> items) {
        if(CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        return items
                .stream()
                .map( item -> InformationOrderItemDTO.builder()
                        .productDescription(item.getProduct().getDescription())
                        .priceUnity(item.getProduct().getPrice())
                        .quantity(item.getQuantity())
                        .build()
                ).collect(Collectors.toList());
    }
}
