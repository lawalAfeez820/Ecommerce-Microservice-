package com.lawal.ecommerce.kakfa.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class Product {

    private Integer productId;

    private String name;

    private String description;

    private Double quantity;

    private BigDecimal amount;


}
