package com.lawal.ecommerce.order;


import com.lawal.ecommerce.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {

    private Integer id;

    private String reference;

    @Positive(message = "Order amount should be positive")
    private BigDecimal amount;

    @NotNull(message ="Payment Method should be precise")
    @NotEmpty(message ="Payment Method should be precise")
    @NotBlank(message ="Payment Method should be precise")
    private PaymentMethod paymentMethod;

    @NotNull(message ="Customer should be present")
    private String customerId;

    @NotEmpty(message= "You should atleast purchase one product")
    private List<PurchaseRequest> products;


}
