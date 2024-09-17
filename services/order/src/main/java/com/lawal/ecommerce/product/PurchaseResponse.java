package com.lawal.ecommerce.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class PurchaseResponse {

    private Integer productId;

    private String name;

    private String description;

    private BigDecimal price;

    private double quantity;

}
