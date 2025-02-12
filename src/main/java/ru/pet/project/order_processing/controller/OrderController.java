package ru.pet.project.order_processing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.project.order_processing.db.OrderRepository;
import ru.pet.project.order_processing.db.tables.pojos.Orders;

/**
 * @author Gamma on 12.02.2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderRepository orderRepository;


    @PostMapping
    public Orders save(@RequestBody Orders order) {
        return orderRepository.save(order);
    }
}
