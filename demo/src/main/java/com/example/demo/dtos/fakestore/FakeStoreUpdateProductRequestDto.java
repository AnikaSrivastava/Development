package com.example.demo.dtos.fakestore;

import com.example.demo.dtos.products.UpdateProductRequestDto;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreUpdateProductRequestDto {

    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;



}
