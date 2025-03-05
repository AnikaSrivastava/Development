package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel {

    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @JsonBackReference
    private List<Product> allProducts;
    private int countOfProducts;

}
