package com.lawal.ecommerce.payment;


import com.lawal.ecommerce.notification.NotificationProducer;
import com.lawal.ecommerce.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;

    private final PaymentMapper paymentMapper;

    public Integer createPayment(PaymentRequest request) {

        Payment payment = paymentRepository
                .save(paymentMapper
                        .toPayment(request)
                );

        notificationProducer.sendNotification(
                PaymentNotificationRequest
                        .builder()
                        .paymentMethod(request.getPaymentMethod())
                        .amount(request.getAmount())
                        .customerEmail(request.getCustomer().getEmail())
                        .customerId(request.getCustomer().getId())
                        .customerLastName(request.getCustomer().getLastName())
                        .orderReference(request.getOrderReference())
                        .build()
        );



        return payment.getId();
    }
}
