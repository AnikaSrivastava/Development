package com.example.demo.services;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product) throws RestClientException;

    List<Product> getAllProducts();

    Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException;

    Product getProduct(Long productId) throws ProductNotFoundException;

    Product deleteProduct(Long productId) throws ProductNotFoundException;


}
