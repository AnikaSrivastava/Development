package com.example.demo.repositories;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repositor
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select p from Product p where p.category.name = :name")
    public Product fetchProductDataRandom(@Param("name") String name);


}
