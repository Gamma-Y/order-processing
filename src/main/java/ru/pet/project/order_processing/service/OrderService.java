package ru.pet.project.order_processing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import ru.pet.project.order_processing.controller.model.OrderRequest;
import ru.pet.project.order_processing.db.OrderRepository;
import ru.pet.project.order_processing.db.enums.OrderStatus;
import ru.pet.project.order_processing.db.tables.pojos.Orders;

import java.util.UUID;

/**
 * @author Gamma on 17.02.2025
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderSaga orderSaga;

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public Orders createOrder(OrderRequest request) {
        Orders order = new Orders();
        order.setId(UUID.randomUUID());
        order.setStatus(OrderStatus.CREATED);

        orderSaga.processOrder(order);
        return orderRepository.save(order);
    }
}
