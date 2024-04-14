package com.techorg.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techorg.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{ }
