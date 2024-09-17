package com.lawal.ecommerce.order;


import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {

        return Order
                .builder()
                .customerId(request.getCustomerId())
                .reference(request.getReference())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .build();
    }


    public OrderResponse toOrderResponse(Order order) {

        return OrderResponse
                .builder()
                .id(order.getId())
                .reference(order.getReference())
                .amount(order.getAmount())
                .customerId(order.getCustomerId())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }
}
