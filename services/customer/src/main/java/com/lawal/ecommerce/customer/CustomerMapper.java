package com.lawal.ecommerce.customer;


import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {

        return Customer
                .builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {

        return CustomerResponse
                .builder()
                .address(customer.getAddress())
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .email(customer.getEmail())
                .lastName(customer.getLastName())
                .build();
    }
}
