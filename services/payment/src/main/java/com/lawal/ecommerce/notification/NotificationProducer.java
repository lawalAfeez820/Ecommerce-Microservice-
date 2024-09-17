package com.lawal.ecommerce.notification;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, PaymentNotificationRequest> paymentNotificationRequestKafkaTemplate;

    public void sendNotification(PaymentNotificationRequest request)
    {
        log.info("Sending payment notification");

        Message<PaymentNotificationRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "payment-topics")
                .build();

        paymentNotificationRequestKafkaTemplate.send(message);
    }



}
