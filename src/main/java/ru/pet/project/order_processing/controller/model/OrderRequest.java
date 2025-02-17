package ru.pet.project.order_processing.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Gamma on 17.02.2025
 */
@Data
public class OrderRequest {
    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    @NotEmpty(message = "Order items cannot be empty")
    private List<OrderItemRequest> items;
}
