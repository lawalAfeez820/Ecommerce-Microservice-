package com.lawal.ecommerce.orderline;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderLineRequest {
    private Integer orderId;
    private Integer productId;
    private Double quantity;

}
