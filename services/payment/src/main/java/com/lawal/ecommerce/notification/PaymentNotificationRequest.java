package com.lawal.ecommerce.notification;


import com.lawal.ecommerce.payment.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotificationRequest {

    private String orderReference;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private String customerId;

    private String customerLastName;

    private String customerEmail;






}
