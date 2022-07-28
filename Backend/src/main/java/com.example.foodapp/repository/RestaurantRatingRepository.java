package com.example.foodapp.repository;

import com.example.foodapp.model.entities.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRatingRepository extends JpaRepository<RestaurantRating,Long>{
    RestaurantRating findById(long id);

    List<RestaurantRating> findAllByRestaurantId(long restaurantId);
}
