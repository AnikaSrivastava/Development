package com.example.demo.dtos.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.demo.models.Product;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponseDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }

}
