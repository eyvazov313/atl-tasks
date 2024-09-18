package com.mstask.orderms.controller;

import com.mstask.orderms.dto.CustomerResponse;
import com.mstask.orderms.dto.OrderDTO;
import com.mstask.orderms.service.CustomerService;
import com.mstask.orderms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final CustomerService customerService;

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO){
        orderService.toOrder(orderDTO);
        return ResponseEntity.ok().build();
    }
}
