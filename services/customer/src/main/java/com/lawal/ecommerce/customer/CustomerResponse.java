package com.lawal.ecommerce.customer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class CustomerResponse {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}
