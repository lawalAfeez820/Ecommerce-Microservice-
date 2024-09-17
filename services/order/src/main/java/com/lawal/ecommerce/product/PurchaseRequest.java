package com.lawal.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PurchaseRequest {

    @NotNull(message = "Product is mandatory")
    private Integer productId;

    @Positive(message ="Quantity is Mandatory")
    private Double quantity;
}
