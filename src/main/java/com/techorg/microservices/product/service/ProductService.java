package com.techorg.microservices.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.techorg.microservices.product.dto.ProductRequest;
import com.techorg.microservices.product.dto.ProductResponse;
import com.techorg.microservices.product.model.Product;
import com.techorg.microservices.product.repository.ProductRepository;


@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                            .name(productRequest.name())
                            .description(productRequest.description())
                            .price(productRequest.price())
                            .build();
        productRepository.save(product);
        log.info("Product created successfully, product name : {}", product.getName());
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }

}
