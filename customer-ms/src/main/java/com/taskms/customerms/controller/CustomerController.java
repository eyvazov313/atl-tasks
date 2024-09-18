package com.taskms.customerms.controller;

import com.taskms.customerms.dto.CustomerRequest;
import com.taskms.customerms.dto.CustomerResponse;
import com.taskms.customerms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
//@Validated
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.add(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getById(id));
    }


    @PatchMapping
    public ResponseEntity<Void> updateCustomerById(@RequestParam Long id, @RequestBody CustomerRequest customerRequest){
        customerService.updateById(id, customerRequest);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id){
        customerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllCustomers(){
        customerService.deleteAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
