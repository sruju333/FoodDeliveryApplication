package com.example.foodapp.controller;

import com.example.foodapp.model.request.CreateRestaurant;
import com.example.foodapp.model.request.RestaurantDetailsUpdate;
import com.example.foodapp.model.response.CreateRestaurantResponse;
import com.example.foodapp.model.response.Response;
import com.example.foodapp.model.response.UpdateRestaurantResponse;
import com.example.foodapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
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
