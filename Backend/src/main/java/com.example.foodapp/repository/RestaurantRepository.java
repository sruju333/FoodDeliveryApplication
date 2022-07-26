package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
