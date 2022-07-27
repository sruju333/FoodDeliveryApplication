package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByRestaurantId(long restaurantId);
    Product findByProductId(long productId);

}
