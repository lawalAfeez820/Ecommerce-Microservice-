package com.lawal.ecommerce.orderline;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-lines")
@Tag(name ="OrderLine")
public class OrderLineController {

    private final OrderLineService orderLineService;


    @GetMapping("order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findOrderById(

            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(orderLineService.findAllById(orderId));
    }
}
