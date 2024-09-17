package com.lawal.ecommerce.payment;


import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private Integer id;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private Integer orderId;

    private String orderReference;

    private Customer customer;

}
