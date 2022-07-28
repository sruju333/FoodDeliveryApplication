package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,Long> {


    List<Order> findByRestaurantId(Long restaurantId);
    List<Order> findByUserId(Long userId);



}
