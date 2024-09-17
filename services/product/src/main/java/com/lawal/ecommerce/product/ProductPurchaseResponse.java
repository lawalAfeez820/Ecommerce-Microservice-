package com.lawal.ecommerce.product;

import lombok.*;

import java.math.BigDecimal;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseResponse {

    private Integer productId;

    private String name;

    private String description;

   private BigDecimal totalPrice;

   private BigDecimal pricePerOne;

   private double quantityBought;
}
