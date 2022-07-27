package com.example.foodapp.controller;

import com.example.foodapp.model.entities.RestaurantRating;
import com.example.foodapp.repository.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.request.CreateRestaurant;
import com.example.foodapp.model.request.RestaurantDetailsUpdate;
import com.example.foodapp.model.response.CreateRestaurantResponse;
import com.example.foodapp.model.response.UpdateRestaurantResponse;
import com.example.foodapp.service.ProductService;
import com.example.foodapp.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/restaurant")

public class RestaurantController {

    @Autowired
    RestaurantRatingRepository restaurantRatingRepository;

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    ProductService productService;

    @PostMapping(value = "/rating", consumes = "application/json")
    public String addRating(@RequestBody RestaurantRating restaurantRating) {
        restaurantRatingRepository.save(restaurantRating);
        return "Rating received! Thanks :)";
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Restaurant>> getAll(){
        return new ResponseEntity<List<Restaurant>>(restaurantService.getALl(), HttpStatus.OK);
    }

    @GetMapping(value = "/{RmId}")
    public ResponseEntity<List<Restaurant>> getAllForManager(@PathVariable long RmId){
        List<Restaurant> Allrestaurants=restaurantService.getALlForManager(RmId);

        return new ResponseEntity<List<Restaurant>>(Allrestaurants,HttpStatus.OK);
    }

    @GetMapping(value = "/products/{RId}")
    public ResponseEntity<List<Product>> getAllItems(@PathVariable long RId){
        List<Product> AllProducts=productService.getALlItems(RId);
        //RestaurantRating rating= restaurantService.getRestaurantRating(RId);
        return new ResponseEntity<List<Product>>(AllProducts,HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public UpdateRestaurantResponse update(@RequestBody RestaurantDetailsUpdate restaurantDetailsUpdate){

        UpdateRestaurantResponse updateRestaurantResponse=restaurantService.updateRestaurantDetails(restaurantDetailsUpdate);
        return updateRestaurantResponse;
    }
    @PostMapping(value = "/add")
    public CreateRestaurantResponse create(@RequestBody CreateRestaurant createRestaurant){
        CreateRestaurantResponse createRestaurantResponse=restaurantService.restaurantCreate(createRestaurant);
        return createRestaurantResponse;
    }


}
