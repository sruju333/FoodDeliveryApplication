package com.example.foodapp.repository;


import com.example.foodapp.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======

import java.util.List;

>>>>>>> b8f10ad77250892cc2dabd874211605bd3f4f3d7
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findAll();
    List<Restaurant> findById(long restaurantManagerId);
    Restaurant findByRestaurantId(Long restaurantId);


}
