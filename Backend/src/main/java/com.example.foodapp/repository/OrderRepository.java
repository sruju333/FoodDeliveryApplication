package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderId(Long orderId);
    List<Order> findByUserId(Long userId);
    List<Order> findByRestaurantId(Long restaurantId);

}
