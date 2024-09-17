package com.lawal.ecommerce.kakfa.payment;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class PaymentConfirmation {

    private String orderReference;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private String customerFirstName;

    private String customerLastName;

    private String customerEmail;




}
