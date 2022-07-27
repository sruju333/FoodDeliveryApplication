package com.example.foodapp.service;

import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.RestaurantRating;
import com.example.foodapp.repository.RestaurantRatingRepository;
import com.example.foodapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    RestaurantRatingRepository restaurantRatingRepository;

    public List<Restaurant> getALl(){
        List<Restaurant> ALlRestaurants=restaurantRepository.findAll();
        return ALlRestaurants;
    }
    public List<Restaurant> getALlForManager(long RmId){
        List<Restaurant> AllRestaurants=restaurantRepository.findById(RmId);
        return AllRestaurants;
    }
    public RestaurantRating getRestaurantRating(long Id){
      RestaurantRating rating = restaurantRatingRepository.findById(Id);
      return rating;
    }
}
