package com.lawal.ecommerce.email;


import lombok.Getter;

@Getter
public enum EmailTemplate {

    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment Sucessfully Processed"),

    ORDER_CONFIRMATION("order-confirmation.html", "Order Confirmation");

    private final String templateName;
    private final String mailSubject;

    EmailTemplate(String templateName, String mailSubject) {
        this.templateName = templateName;
        this.mailSubject = mailSubject;
    }
}
