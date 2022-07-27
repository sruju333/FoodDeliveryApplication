package com.example.foodapp.controller;


import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.entities.RestaurantRating;
import com.example.foodapp.repository.RestaurantRepository;
import com.example.foodapp.service.ProductService;
import com.example.foodapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController


public class RestaurantController {
//
    @Autowired
    RestaurantService restaurantService;

    ProductService productService;
//
    @GetMapping(value = "/restaurant",consumes = "application/json", produces = "application/json")
   public ResponseEntity<List<Restaurant>> getAll(){
    return new ResponseEntity<List<Restaurant>>(restaurantService.getALl(), HttpStatus.OK);
    }
//
    @GetMapping(value = "/restaurant/{RmId}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<Restaurant>> getAllForManager(@RequestParam("RmId") long RmId){
        List<Restaurant> Allrestaurants=restaurantService.getALlForManager(RmId);

        return new ResponseEntity<List<Restaurant>>(Allrestaurants,HttpStatus.OK);
    }
//
    @GetMapping(value = "/restaurant/products/{RId}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<Product>> getAllItems(@RequestParam("RId") long RId){
        List<Product> AllProducts=productService.getALlItems(RId);
        //RestaurantRating rating= restaurantService.getRestaurantRating(RId);
        return new ResponseEntity<List<Product>>(AllProducts,HttpStatus.OK);
    }



}
