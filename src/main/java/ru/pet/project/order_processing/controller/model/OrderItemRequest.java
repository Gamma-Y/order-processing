package ru.pet.project.order_processing.controller.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

/**
 * @author Gamma on 17.02.2025
 */
@Data
public class OrderItemRequest {
    @NotNull(message = "Item ID cannot be null")
    private UUID itemId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
}
