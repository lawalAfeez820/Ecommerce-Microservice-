package com.lawal.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerUpdateRequest {

    @NotNull(message = "Customer FirstName is required")
    private String firstName;

    @NotNull(message = "Customer LastName is required")
    private String lastName;

    private Address address;
}
