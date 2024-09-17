package com.lawal.ecommerce.order;


import com.lawal.ecommerce.customer.CustomerClient;
import com.lawal.ecommerce.customer.CustomerResponse;
import com.lawal.ecommerce.exception.OrderErrorException;
import com.lawal.ecommerce.exception.CustomerNotFoundException;
import com.lawal.ecommerce.kafka.OrderConfirmation;
import com.lawal.ecommerce.kafka.OrderProducer;
import com.lawal.ecommerce.orderline.OrderLineRequest;
import com.lawal.ecommerce.orderline.OrderLineService;
import com.lawal.ecommerce.payment.PaymentClient;
import com.lawal.ecommerce.payment.PaymentRequest;
import com.lawal.ecommerce.product.ProductClient;
import com.lawal.ecommerce.product.PurchaseRequest;
import com.lawal.ecommerce.product.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {

        CustomerResponse customer = customerClient.findById(request.getCustomerId())
                .orElseThrow(()-> new CustomerNotFoundException("Cannot make an order, because no customer with an id: " +
                        request.getCustomerId()));

        List<PurchaseResponse> response = productClient.purchaseProduct(request.getProducts());

        Order order = orderRepository.save(orderMapper.toOrder(request));

        for (PurchaseRequest purchaseRequest: request.getProducts()){

            orderLineService.saveOrderLine(OrderLineRequest
                    .builder()
                            .orderId(order.getId())
                            .productId(purchaseRequest.getProductId())
                            .quantity(purchaseRequest.getQuantity())
                    .build()

                    );

            // todo start payment process

            paymentClient.createPayment(
                    PaymentRequest
                            .builder()
                            .paymentMethod(request.getPaymentMethod())
                            .orderReference(order.getReference())
                            .orderId(order.getId())
                            .amount(request.getAmount())
                            .customer(customer)
                            .build()

            );


            orderProducer.sendOrderConfirmation(
                    OrderConfirmation
                            .builder()
                            .orderReference(request.getReference())
                            .customerResponse(customer)
                            .paymentMethod(request.getPaymentMethod())
                            .purchaseResponses(response)
                            .totalAmount(request.getAmount())
                            .build()
            );

        }

        return order.getId();
    }

    public List<OrderResponse> findAll() {

        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    public OrderResponse findById(Integer orderId) {

        return orderRepository.findById(orderId)
                .map(orderMapper::toOrderResponse)
                .orElseThrow(()->new OrderErrorException("No Order with an Id: "
                        + orderId));
    }


}
