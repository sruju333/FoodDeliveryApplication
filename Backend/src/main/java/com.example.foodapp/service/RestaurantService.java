package com.example.foodapp.service;

import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.User;
import com.example.foodapp.model.request.RestaurantDetailsUpdate;
import com.example.foodapp.model.response.Response;
import com.example.foodapp.repository.RestaurantRepository;
import com.example.foodapp.repository.UserRepository;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    public Response updateRestaurantDetails(RestaurantDetailsUpdate restaurantDetailsUpdate){
        Restaurant restaurant=restaurantRepository.findByRestaurantId(restaurantDetailsUpdate.getRestaurantId());
        Response response=new Response();
        if(restaurant==null){
            response.setStatus(false);
            response.setMessage("please enter valid restaurant id");
        }else{

            if(restaurant.getRestaurantId()==restaurantDetailsUpdate.getRestaurantId()){
                Long id=restaurant.getRestaurantManagerId();
                User user=userRepository.findByUserId(id);
                String jwt1=user.getJwt();
                if(!(jwt1.equals(restaurantDetailsUpdate.getJwt()))){
                    response.setStatus(false);
                    response.setMessage("no such restaurant id for user");
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
                    response.setStatus(true);
                    response.setMessage("Restaurant details updated successfully");
                }

            }else{
                response.setStatus(false);
                response.setMessage(("no such restaurant id"));
            }
        }
        return response;
    }

}
