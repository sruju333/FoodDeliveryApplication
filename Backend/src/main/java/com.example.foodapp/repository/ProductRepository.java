package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByRestaurantId(long restaurantId);
    Product findByProductId(long productId);

}
