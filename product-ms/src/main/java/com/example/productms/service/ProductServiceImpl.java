package com.example.productms.service;

import com.example.productms.dto.ProductRequest;
import com.example.productms.dto.ProductResponse;
import com.example.productms.entity.Product;
import com.example.productms.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

//    private final ProductMapper mapper;

    @Override
    public void add(ProductRequest productRequest) {
        productRepository.save(Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .count(productRequest.getCount())
                .build());
    }

    @Override
    public ProductResponse getById(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .count(product.getCount())
                .build();
    }

    @Override
    public void updateProductById(Long id, ProductRequest productRequest) {
        var productEntity = productRepository.findById(id).orElseThrow();
        if (productRequest.getName() != null) productEntity.setName(productRequest.getName());
        if (productRequest.getCount() != null) productEntity.setCount(productRequest.getCount());
        if (productRequest.getPrice() != null) productEntity.setPrice(productRequest.getPrice());
        productRepository.save(productEntity);
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream()
                .map(product -> ProductResponse.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .count(product.getCount())
                        .build()).collect(Collectors.toList());
    }
}
