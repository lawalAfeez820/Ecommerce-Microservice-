package com.lawal.ecommerce.kakfa;


import com.lawal.ecommerce.email.EmailServer;

import com.lawal.ecommerce.kakfa.order.OrderConfirmation;
import com.lawal.ecommerce.kakfa.order.Product;
import com.lawal.ecommerce.kakfa.payment.PaymentConfirmation;
import com.lawal.ecommerce.notification.Notification;
import com.lawal.ecommerce.notification.NotificationRepository;
import com.lawal.ecommerce.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;

    private final EmailServer emailService;

    @KafkaListener(topics = "payment-topics")
    public void consumePaymentSuccessNotification(
            PaymentConfirmation paymentConfirmation) throws MessagingException {
        notificationRepository.save(
                Notification
                        .builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        String customerName = paymentConfirmation.getCustomerFirstName()
                + paymentConfirmation.getCustomerLastName();

        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.getCustomerEmail(),
                customerName,
                paymentConfirmation.getAmount(),
                paymentConfirmation.getOrderReference()


        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(
            OrderConfirmation orderConfirmation) throws MessagingException {
        notificationRepository.save(
                Notification
                        .builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        String customerName = orderConfirmation.getCustomer().getFirstName()
                + orderConfirmation.getCustomer().getLastName();

        emailService.sendOrderConfirmationEmail(

                orderConfirmation.getCustomer().getEmail(),
                customerName,
                orderConfirmation.getAmount(),
                orderConfirmation.getOrderReference(),
                orderConfirmation.getProducts()
        );
    }


}
