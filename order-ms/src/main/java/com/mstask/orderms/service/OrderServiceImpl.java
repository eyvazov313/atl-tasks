package com.mstask.orderms.service;

import com.mstask.orderms.dto.CustomerRequest;
import com.mstask.orderms.dto.OrderDTO;
import com.mstask.orderms.dto.ProductRequest;
import com.mstask.orderms.entity.Order;
import com.mstask.orderms.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    @Override
//    @Transactional
    public void toOrder(OrderDTO orderDTO) {
        var customerResponse = customerService.getCustomerById(orderDTO.getCustomerId());
        if (!customerResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Customer not found");
        }
        var productResponse = productService.getProductById(orderDTO.getProductId());
        if (!productResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Product not found");
        }

        var customerBalance = customerResponse.getBody().getBalance();
        var productPrice = productResponse.getBody().getPrice();
        var productCount = productResponse.getBody().getCount();

        if (customerBalance.compareTo(productPrice) >= 0) {
            customerBalance = customerBalance.subtract(productPrice);
            productCount = productCount - 1;
        }

        customerService.updateCustomerById(orderDTO.getCustomerId(), CustomerRequest.builder()
                .balance(customerBalance)
                .build());

        productService.updateProductById(orderDTO.getProductId(), ProductRequest.builder()
                .count(productCount)
                .build());

        orderRepository.save(Order.builder()
                .customerId(orderDTO.getCustomerId())
                .productId(orderDTO.getProductId())
                .build());
    }
}
