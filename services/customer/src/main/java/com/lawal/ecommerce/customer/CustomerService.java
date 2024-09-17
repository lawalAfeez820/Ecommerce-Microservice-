package com.lawal.ecommerce.customer;


import com.lawal.ecommerce.exception.CustomerAlreadyExistException;
import com.lawal.ecommerce.exception.CustomerNotFoundException;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Map<String, String> createCustomer(CustomerRequest request) {

        var output = new HashMap<String, String>();

        if (customerRepository.findByEmail(request.getEmail()).isPresent())
            throw new CustomerAlreadyExistException("Customer with the email specified already exist");

        String id = customerRepository.save(customerMapper.toCustomer(request)).getId();

        output.put("Customer Id", id);

        return output;

    }

    public void updateCustomer(@Valid CustomerUpdateRequest request, String customerId) {

        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("No customer with an id: " + customerId));

        mergeCustomer(customer, request);
        customerRepository.save(customer);

    }

    private void mergeCustomer(Customer customer, @Valid CustomerUpdateRequest request) {

        if (StringUtils.isNotBlank(request.getFirstName()))
            customer.setFirstName(request.getFirstName());

        if (StringUtils.isNotBlank(request.getLastName()))
            customer.setLastName(request.getLastName());

        if (request.getAddress() != null)
            customer.setAddress(request.getAddress());

    }

    public List<CustomerResponse> findAll() {

            List<Customer> customers = customerRepository.findAll();

            return customers.stream().map(customerMapper::toCustomerResponse).toList();

    }

    public Boolean ifExist(String customerId) {

        return customerRepository
                .findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(String customerId) {

       Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerNotFoundException("No customer with an id of " + customerId));
        return customerMapper.toCustomerResponse(customer);
    }

    public void deleteById(String customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerNotFoundException("No customer with an id of " + customerId));

        customerRepository.deleteById(customerId);

    }
}
