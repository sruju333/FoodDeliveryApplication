package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,Long> {
    List<Product> findByRestaurantId(long restaurantId);


}
