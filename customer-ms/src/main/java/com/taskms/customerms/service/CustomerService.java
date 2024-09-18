package com.taskms.customerms.service;

import com.taskms.customerms.dto.CustomerRequest;
import com.taskms.customerms.dto.CustomerResponse;
import com.taskms.customerms.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    void add(CustomerRequest customerRequest);

    List<CustomerResponse> getAll();

    CustomerResponse getById(Long id);

    void updateById(Long id, CustomerRequest customerRequest);

    void deleteById(Long id);

    void deleteAllCustomers();
}
