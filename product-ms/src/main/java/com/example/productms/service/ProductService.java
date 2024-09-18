package com.example.productms.service;

import com.example.productms.dto.ProductRequest;
import com.example.productms.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void add(ProductRequest productRequest);

    ProductResponse getById(Long id);

    void updateProductById(Long id, ProductRequest productRequest);

    List<ProductResponse> getAll();
}
