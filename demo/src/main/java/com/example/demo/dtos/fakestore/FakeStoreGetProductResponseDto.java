package com.example.demo.dtos.fakestore;

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
public class FakeStoreGetProductResponseDto {

    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public Product toProduct() {
        Product product1 = new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setImageUrl(this.getImage());
        Category category1 = new Category();
        category1.setName(category);
        product1.setCategory(category1);
        product1.setPrice(this.getPrice());

        return product1;
    }

}
