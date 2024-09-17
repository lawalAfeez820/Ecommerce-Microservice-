package com.lawal.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "Product name is required")
    private String name;

    @NotNull(message = "Product description is required")
    private String description;

    @NotNull(message = "Product available quantity is required")
    @Positive(message = "The Available Quantity is Must be positive")
    private double availableQuantity;

    @Positive(message = "The Price is Must be positive")
    private BigDecimal price;

    @NotNull(message = "Product category is required")
    private Integer categoryId;

}
