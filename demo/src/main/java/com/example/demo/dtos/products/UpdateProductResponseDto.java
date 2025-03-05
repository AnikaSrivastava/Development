package com.example.demo.dtos.products;

import com.example.demo.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponseDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static UpdateProductResponseDto fromProduct(Product product) {
        UpdateProductResponseDto responseDto = new UpdateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }

}
