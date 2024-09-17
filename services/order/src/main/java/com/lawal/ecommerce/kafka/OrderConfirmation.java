package com.lawal.ecommerce.kafka;


import com.lawal.ecommerce.customer.CustomerResponse;
import com.lawal.ecommerce.order.PaymentMethod;
import com.lawal.ecommerce.product.PurchaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderConfirmation {

    private String orderReference;

    private BigDecimal totalAmount;

    private PaymentMethod paymentMethod;

    private CustomerResponse customerResponse;

    private List<PurchaseResponse> purchaseResponses;

}
