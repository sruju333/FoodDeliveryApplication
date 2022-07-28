package com.example.foodapp.repository;


import com.example.foodapp.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant,Long> {

    List<Restaurant> findAll();
    List<Restaurant> findByRestaurantManagerId(long restaurantManagerId);



}
