package com.example.foodapp.controller;

import com.example.foodapp.model.entities.RestaurantRating;
import com.example.foodapp.repository.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantRatingRepository restaurantRatingRepository;

    @PostMapping(value = "/rating", consumes = "application/json")
    public String addRating(@RequestBody RestaurantRating restaurantRating){
        restaurantRatingRepository.save(restaurantRating);
        return "Rating received! Thanks :)";
    }


}
