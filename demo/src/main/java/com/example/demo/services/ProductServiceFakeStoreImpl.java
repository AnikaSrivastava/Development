package com.example.demo.services;


import com.example.demo.dtos.fakestore.FakeStoreCreateProductRequestDto;
import com.example.demo.dtos.fakestore.FakeStoreGetProductResponseDto;
import com.example.demo.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {


    private final RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {

        FakeStoreCreateProductRequestDto requestDTO = new FakeStoreCreateProductRequestDto();
        requestDTO.setCategory(product.getCategory().getName());
        requestDTO.setTitle(product.getTitle());
        requestDTO.setImage(product.getImageUrl());
        requestDTO.setDescription(product.getDescription());
        requestDTO.setPrice(product.getPrice());

        FakeStoreGetProductResponseDto responseDTO =
                restTemplate.postForObject("https://fakestoreapi.com/products", requestDTO, FakeStoreGetProductResponseDto.class);
        assert responseDTO != null;
        return responseDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreGetProductResponseDto[] responseDTOS = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreGetProductResponseDto[].class);
        assert responseDTOS != null;
        List<Product> productList = new ArrayList<>();
        for (FakeStoreGetProductResponseDto responseDTO : responseDTOS) {
            productList.add(responseDTO.toProduct());
        }

        return productList;
    }

    @Override
    public Product getProduct(Long productId) {
        FakeStoreGetProductResponseDto productResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreGetProductResponseDto.class);
        assert productResponseDto != null;
        return productResponseDto.toProduct();
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {

        return null;
    }
}
