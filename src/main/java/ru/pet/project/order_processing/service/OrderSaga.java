package ru.pet.project.order_processing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pet.project.order_processing.db.enums.OrderStatus;
import ru.pet.project.order_processing.db.tables.pojos.Orders;

/**
 * @author Gamma on 17.02.2025
 */
@Service
@RequiredArgsConstructor
public class OrderSaga {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Transactional
    public void processOrder(Orders order) {
        try {

            kafkaTemplate.send("order-status", order.getId().toString());


            order.setStatus(OrderStatus.PROCESSING);
            kafkaTemplate.send("order-status", order.getId().toString());


            order.setStatus(OrderStatus.COMPLETED);
            kafkaTemplate.send("order-status", order.getId().toString());
        } catch (Exception e) {

            order.setStatus(OrderStatus.CANCELLED);
            kafkaTemplate.send("order-status", order.getId().toString());
        }
    }
}
