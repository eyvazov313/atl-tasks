package com.mstask.orderms.service;

import com.mstask.orderms.dto.ProductRequest;
import com.mstask.orderms.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-ms", url = "localhost:8081/api/v1/product")
public interface ProductService {

    @GetMapping("/{id}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable Long id);

    @PatchMapping
    ResponseEntity<?> updateProductById(@RequestParam Long id, @RequestBody ProductRequest productRequest);
}
