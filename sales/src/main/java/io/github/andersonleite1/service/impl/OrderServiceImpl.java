package io.github.andersonleite1.service.impl;

import io.github.andersonleite1.api.dto.ItemOrderDTO;
import io.github.andersonleite1.api.dto.OrderDTO;
import io.github.andersonleite1.domain.entity.Client;
import io.github.andersonleite1.domain.entity.ItemOrder;
import io.github.andersonleite1.domain.entity.Order;
import io.github.andersonleite1.domain.entity.Product;
import io.github.andersonleite1.domain.repository.Clients;
import io.github.andersonleite1.domain.repository.ItemsOrder;
import io.github.andersonleite1.domain.repository.Orders;
import io.github.andersonleite1.domain.repository.Products;
import io.github.andersonleite1.enums.OrderStatus;
import io.github.andersonleite1.exception.BusinessRuleException;
import io.github.andersonleite1.exception.OrderNotFoundException;
import io.github.andersonleite1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final Orders ordersRepository;
    private final Clients clientsRepository;
    private final Products productsRepository;
    private final ItemsOrder itemsOrderRepository;

    public Order save(OrderDTO dto) {
        Integer clientId = dto.getClient();
        Client client = clientsRepository
                .findById(clientId)
                .orElseThrow(() -> new BusinessRuleException("Violation business rule"));

        Order order = new Order();
        order.setTotal(dto.getTotal());
        order.setDateOrder(LocalDate.now());
        order.setClient(client);

        List<ItemOrder> itemOrders = converterItems(order, dto.getItems());
        ordersRepository.save(order);
        itemsOrderRepository.saveAll(itemOrders);
        return order;
    }

    @Override
    public Optional<Order> getOrderFull(Integer id) {
        return ordersRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateStatus(Integer id, OrderStatus status) {
        ordersRepository
                .findById(id)
                .map(order -> {
                    order.setStatus(status);
                    return ordersRepository.save(order);
                }).orElseThrow(() -> new OrderNotFoundException());
    }

    private List<ItemOrder> converterItems(Order order, List<ItemOrderDTO> items) {
        if(items.isEmpty()) {
            throw new BusinessRuleException("Unable to place an order without items");
        }

        return items
                .stream()
                .map(dto -> {
                    Integer productId = dto.getProduct();
                    Product product = productsRepository
                            .findById(productId)
                            .orElseThrow(() -> new BusinessRuleException("Product code invalid: " + productId));

                    ItemOrder itemOrder = new ItemOrder();
                    itemOrder.setQuantity(dto.getQuantity());
                    itemOrder.setOrder(order);
                    itemOrder.setProduct(product);
                    return itemOrder;
                }).collect(Collectors.toList());
    }
}
