package com.lawal.ecommerce.orderline;


import com.lawal.ecommerce.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {

        return OrderLine
                .builder()
                .productId(orderLineRequest.getProductId())
                .quantity(orderLineRequest.getQuantity())
                .order(Order.builder().id(orderLineRequest.getOrderId()).build())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {

        return OrderLineResponse
                .builder()
                .id(orderLine.getId())
                .quantity(orderLine.getQuantity())
                .build();
    }
}
