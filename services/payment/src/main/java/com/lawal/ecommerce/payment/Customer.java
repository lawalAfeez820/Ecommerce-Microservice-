package com.lawal.ecommerce.payment;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @NotNull(message = "FirstName is required")
    private String firstName;

    @NotNull(message = "Email is required")
    @Email(message = "Customer Email is not correctly formatted")
    private String email;

    private String id;

    @NotNull(message = "LastName is required")
    private String lastName;
}
