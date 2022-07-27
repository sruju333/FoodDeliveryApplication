package com.example.foodapp.service;

import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.RestaurantRating;
import com.example.foodapp.repository.RestaurantRatingRepository;
import com.example.foodapp.repository.RestaurantRepository;

import com.example.foodapp.model.entities.User;
import com.example.foodapp.model.request.CreateRestaurant;
import com.example.foodapp.model.request.RestaurantDetailsUpdate;
import com.example.foodapp.model.response.CreateRestaurantResponse;
import com.example.foodapp.model.response.Response;
import com.example.foodapp.model.response.UpdateRestaurantResponse;

import com.example.foodapp.repository.UserRepository;
import com.mysql.cj.xdevapi.JsonArray;
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
    @Autowired
    UserRepository userRepository;
    public CreateRestaurantResponse restaurantCreate(CreateRestaurant createRestaurant){
        CreateRestaurantResponse createRestaurantResponse=new CreateRestaurantResponse();
        Restaurant restaurant=new Restaurant();
        Long id=createRestaurant.getRestaurantId();
        if(restaurantRepository.findByRestaurantId(id)!=null){
            createRestaurantResponse.setStatus(false);
            createRestaurantResponse.setMessage("sorry, id not available");
        }else{
            restaurant.setRestaurantId(id);
            restaurant.setRestaurantImage(createRestaurant.getRestaurantImage());
            restaurant.setRestaurantName(createRestaurant.getRestaurantName());
            restaurant.setRestaurantAddress(createRestaurant.getRestaurantAddress());
            String jwt=createRestaurant.getJwt();
            User user=userRepository.findByJwt(jwt);
            if(user==null){
                createRestaurantResponse.setStatus(false);
                createRestaurantResponse.setMessage("no such user");
                return createRestaurantResponse;
            }
            Long ManagerId=user.getUserId();
            restaurant.setRestaurantManagerId(ManagerId);
            restaurantRepository.save(restaurant);
            createRestaurantResponse.setStatus(true);
            createRestaurantResponse.setMessage("restaurant added successfully to database");
        }
        return createRestaurantResponse;
    }
    public UpdateRestaurantResponse updateRestaurantDetails(RestaurantDetailsUpdate restaurantDetailsUpdate){
        Restaurant restaurant=restaurantRepository.findByRestaurantId(restaurantDetailsUpdate.getRestaurantId());
        UpdateRestaurantResponse updateRestaurantResponse=new UpdateRestaurantResponse();
        if(restaurant==null){
            updateRestaurantResponse.setStatus(false);
            updateRestaurantResponse.setMessage("please enter valid restaurant id");
        }else{

            if(restaurant.getRestaurantId()==restaurantDetailsUpdate.getRestaurantId()){
                Long id=restaurant.getRestaurantManagerId();
                User user=userRepository.findByUserId(id);
                String jwt1=user.getJwt();
                if(!(jwt1.equals(restaurantDetailsUpdate.getJwt()))){
                    updateRestaurantResponse.setStatus(false);
                    updateRestaurantResponse.setMessage("no such restaurant id for user");
                }
                else{
                    if(restaurantDetailsUpdate.getRestaurantAddress()!=null){
                        restaurant.setRestaurantAddress(restaurantDetailsUpdate.getRestaurantAddress());
                    }
                    if(restaurantDetailsUpdate.getRestaurantName()!=null){
                        restaurant.setRestaurantName(restaurantDetailsUpdate.getRestaurantName());
                    }
                    if(restaurantDetailsUpdate.getRestaurantImage()!=null){
                        restaurant.setRestaurantImage(restaurantDetailsUpdate.getRestaurantImage());
                    }
                    updateRestaurantResponse.setStatus(true);
                    updateRestaurantResponse.setMessage("Restaurant details updated successfully");
                }

            }else{
                updateRestaurantResponse.setStatus(false);
                updateRestaurantResponse.setMessage(("no such restaurant id"));
            }
        }
        return updateRestaurantResponse;
    }

}
