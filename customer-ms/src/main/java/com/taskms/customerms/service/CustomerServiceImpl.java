package com.taskms.customerms.service;

import com.taskms.customerms.dto.CustomerRequest;
import com.taskms.customerms.dto.CustomerResponse;
import com.taskms.customerms.exception.CustomerNotFoundException;
import com.taskms.customerms.mapper.CustomerMapper;
import com.taskms.customerms.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public void add(CustomerRequest customerRequest) {
        customerRepository.save(customerMapper.dtoToEntity(customerRequest));
    }

    @Override
    public List<CustomerResponse> getAll() {
        var customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::entityToDto)
                .orElseThrow(() ->
                        new CustomerNotFoundException("No customer found by id " + id));
    }

    @Override
    public void updateById(Long id, CustomerRequest customerRequest) {
        var customerEntity = customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("No customer found by id " + id));
        customerMapper.updateCustomerFromDto(customerRequest, customerEntity);
        customerRepository.save(customerEntity);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
