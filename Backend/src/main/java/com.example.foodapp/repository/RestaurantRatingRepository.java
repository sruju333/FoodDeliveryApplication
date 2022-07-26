package com.example.foodapp.repository;

import com.example.foodapp.model.entities.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRatingRepository extends JpaRepository<RestaurantRating,Long>{

}
