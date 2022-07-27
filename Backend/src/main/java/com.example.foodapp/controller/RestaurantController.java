package com.example.foodapp.controller;

import com.example.foodapp.model.request.RestaurantDetailsUpdate;
import com.example.foodapp.model.response.Response;
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
    public Response response(@RequestBody RestaurantDetailsUpdate restaurantDetailsUpdate){

        Response response=restaurantService.updateRestaurantDetails(restaurantDetailsUpdate);
        return response;
    }

}
