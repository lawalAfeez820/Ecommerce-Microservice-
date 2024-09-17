package com.lawal.ecommerce.notification;



import com.lawal.ecommerce.kakfa.order.OrderConfirmation;
import com.lawal.ecommerce.kakfa.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    private String id;

    private NotificationType type;

    private LocalDateTime notificationDate;

    private OrderConfirmation orderConfirmation;

    private PaymentConfirmation paymentConfirmation;
}
