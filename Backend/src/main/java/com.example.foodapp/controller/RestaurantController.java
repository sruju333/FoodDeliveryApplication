package com.example.foodapp.controller;



import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.entities.RestaurantRating;
import com.example.foodapp.model.request.CreateRestaurant;
import com.example.foodapp.model.request.RestaurantDetailsUpdate;
import com.example.foodapp.model.response.CreateRestaurantResponse;
import com.example.foodapp.model.response.UpdateRestaurantResponse;
import com.example.foodapp.repository.RestaurantRepository;
import com.example.foodapp.service.ProductService;
import com.example.foodapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    ProductService productService;

    @GetMapping(value = "/",consumes = "application/json", produces = "application/json")
   public ResponseEntity<List<Restaurant>> getAll(){
    return new ResponseEntity<List<Restaurant>>(restaurantService.getALl(), HttpStatus.OK);
    }

    @GetMapping(value = "/{RmId}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<Restaurant>> getAllForManager(@PathVariable long RmId){
        List<Restaurant> Allrestaurants=restaurantService.getALlForManager(RmId);

        return new ResponseEntity<List<Restaurant>>(Allrestaurants,HttpStatus.OK);
    }

    @GetMapping(value = "/products/{RId}",consumes = "application/json",produces = "application/json")
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
