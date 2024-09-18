package com.example.productms.controller;

import com.example.productms.dto.ProductRequest;
import com.example.productms.dto.ProductResponse;
import com.example.productms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public void add(@RequestBody ProductRequest request){
        service.add(request);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(Long id){
        return service.getById(id);
    }

    @GetMapping
    public List<ProductResponse> getAll(){
        return service.getAll();
    }
}
