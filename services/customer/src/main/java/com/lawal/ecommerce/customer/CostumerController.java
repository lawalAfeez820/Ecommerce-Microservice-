package com.lawal.ecommerce.customer;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Tag(name ="Customer")
public class  CostumerController {

    private final CustomerService  customerService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createCustomer(
            @RequestBody @Valid CustomerRequest request
    )
    {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping("/{customer-id}")
    public ResponseEntity<Void> updateCustomer(
         @RequestBody @Valid CustomerUpdateRequest request,
         @RequestParam("customer-id") String customerId

    ){
        customerService.updateCustomer(request, customerId);

        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existById(

            @PathVariable(name ="customer-id") String customerId
    ){
        return ResponseEntity.ok(customerService.ifExist(customerId));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(

            @PathVariable(name ="customer-id") String customerId
    ){
        return ResponseEntity.ok(customerService.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteById(

    @PathVariable(name ="customer-id") String customerId
    ){
        customerService.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }



}
