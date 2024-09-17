package com.lawal.ecommerce.product;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductPurchaseRequest {


    @NotNull(message= "productId is required")
    private Integer productId;

    @Positive(message = "Quantity is required and it must be positive")
    private Double quantity;

}
