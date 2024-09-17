package com.lawal.ecommerce.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class OrderResponse {

    private Integer id;

    private String reference;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private String customerId;

}
