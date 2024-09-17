package com.lawal.ecommerce.orderline;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class OrderLineResponse {

    private Integer id;

    private Double quantity;
}
