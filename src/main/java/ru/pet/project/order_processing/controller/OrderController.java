package ru.pet.project.order_processing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.project.order_processing.controller.model.OrderRequest;
import ru.pet.project.order_processing.db.tables.pojos.Orders;
import ru.pet.project.order_processing.service.OrderService;

/**
 * @author Gamma on 12.02.2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

}
