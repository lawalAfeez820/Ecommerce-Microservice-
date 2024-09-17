package com.lawal.ecommerce.email;


import com.lawal.ecommerce.kakfa.order.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServer {

    private final JavaMailSender mailSender;

    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name());
        mimeMessageHelper.setFrom("lawalkunlay03@gmail.com");
        final String templateName = EmailTemplate
                .PAYMENT_CONFIRMATION
                .getTemplateName();

        Map<String, Object> properties = new HashMap<>();
        properties.put("customerName", customerName);
        properties.put("amount", amount);
        properties.put("orderReference", orderReference);

        Context context = new Context();
        context.setVariables(properties);


        mimeMessageHelper.setSubject(EmailTemplate
                .PAYMENT_CONFIRMATION
                .getMailSubject());
        try {
            String template = templateEngine.process(templateName, context);
            mimeMessageHelper.setText(template, true);
            mimeMessageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO - Email successfully sent to {} with template {} ", destinationEmail, templateName);
        } catch (MessagingException e) {
            log.warn("WARNING - cannot send email to {}", destinationEmail);

        }

    }


    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal totalAmount,
            String orderReference,
            List<Product> products

    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name());
        mimeMessageHelper.setFrom("lawalkunlay03@gmail.com");
        final String templateName = EmailTemplate
                .ORDER_CONFIRMATION
                .getTemplateName();

        Map<String, Object> properties = new HashMap<>();
        properties.put("customerName", customerName);
        properties.put("totalAmount", totalAmount);
        properties.put("orderReference", orderReference);
        properties.put("products", products);

        Context context = new Context();
        context.setVariables(properties);


        mimeMessageHelper.setSubject(EmailTemplate
                .ORDER_CONFIRMATION
                .getMailSubject());
        try {
            String template = templateEngine.process(templateName, context);
            mimeMessageHelper.setText(template, true);
            mimeMessageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO - Email successfully sent to {} with template {} ", destinationEmail, templateName);
        } catch (MessagingException e) {
            log.warn("WARNING - cannot send email to {}", destinationEmail);

        }

    }






}
