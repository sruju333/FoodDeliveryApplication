package com.example.foodapp.repository;


import com.example.foodapp.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findAll();
    List<Restaurant> findById(long restaurantManagerId);
    Restaurant findByRestaurantId(Long restaurantId);


}
