package com.mstask.orderms.service;

import com.mstask.orderms.dto.CustomerRequest;
import com.mstask.orderms.dto.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "customer-ms",url = "localhost:8080/api/v1/customer")
public interface CustomerService {

    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id);

    @PatchMapping
    ResponseEntity<?> updateCustomerById(@RequestParam Long id, @RequestBody CustomerRequest customerRequest);
}
