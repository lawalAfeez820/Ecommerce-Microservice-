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
public class CustomerRequest {

    @NotNull(message = "Customer FirstName is required")
    private String firstName;

    @NotNull(message = "Customer LastName is required")
    private String lastName;

    @NotNull(message = "Customer email is required")
    @Email(message = "Email not well formatted, it is not a valid email address")
    private String email;

    private Address address;
}
