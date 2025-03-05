package com.example.demo.services;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceDBImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceDBImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(new java.util.Date());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException {


        Optional<Product> productToUpdateOptional = productRepository.findById(productId);

        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productToUpdate = productToUpdateOptional.get();

        Optional<Product> optionalProduct =  productRepository.findById(productId);

        if(product.getDescription() != null)
        {
            productToUpdate.setDescription(product.getDescription());
        }

        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }

        if (product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }

        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }

        return productRepository.save(productToUpdate);

    }

    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }

        return product.get();

    }

    String uuid = "420f5f12-aa15-422f-b1c9-a4bc2b6c4e23";
    @Override
    public Product deleteProduct(Long productId) throws ProductNotFoundException {

        Optional<Product> productToUpdateOptional = productRepository.findById(productId);
        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productToDelete = productToUpdateOptional.get();

        productToDelete.setDeleted(true);
        return productRepository.save(productToDelete);


    }
}
