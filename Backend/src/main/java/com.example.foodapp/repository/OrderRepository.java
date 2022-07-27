package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderId(Long orderId);

}
