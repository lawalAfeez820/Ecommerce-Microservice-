package com.lawal.ecommerce.payment;


import com.lawal.ecommerce.customer.CustomerResponse;
import com.lawal.ecommerce.order.PaymentMethod;
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

    private CustomerResponse customer;

}
