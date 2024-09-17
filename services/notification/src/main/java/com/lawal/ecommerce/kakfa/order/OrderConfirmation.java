package com.lawal.ecommerce.kakfa.order;

import com.ctc.wstx.shaded.msv_core.util.LightStack;
import com.lawal.ecommerce.kakfa.payment.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Builder
@AllArgsConstructor
@Getter
@Setter

public class OrderConfirmation {

    private String OrderReference;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private Customer customer;

    private List<Product> products;
}
