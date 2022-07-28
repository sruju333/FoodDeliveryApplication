package com.example.foodapp.repository;

import com.example.foodapp.model.entities.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRatingRepository extends MongoRepository<RestaurantRating,Long> {



}
