package com.example.demo.controller;

import com.example.demo.dtos.products.CreateProductRequestDto;
import com.example.demo.dtos.products.CreateProductResponseDto;
import com.example.demo.dtos.products.GetAllProductsResponseDto;
import com.example.demo.dtos.products.GetProductDto;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // private RestTemplate restTemplate;
    private final ProductService productService;

    public ProductController(RestTemplate restTemplate, ProductService productService) {
        //this.restTemplate = restTemplate;
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDTO) {

        //toProduct converts DTO to product and then the product is passed to service to call fakestore
        Product product = productService.createProduct(createProductRequestDTO.toProduct());

        //product from fakestore to be converted to dto and returned to client
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts() {

        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();

        List<GetProductDto> getProductResponseDtos = new ArrayList<>();

        for (Product product: products) {
            getProductResponseDtos.add(GetProductDto.from(product));
        }

        response.setProducts(getProductResponseDtos);

        return response;

    }

    @GetMapping("/{id}")
    public GetProductDto getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
            Product product = productService.getProduct(id);

        return GetProductDto.from(product);


    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.deleteProduct(id);

    }

    @PutMapping("")
    public void replaceProduct() {

    }

    /*@PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(){}*/


}
