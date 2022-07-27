package com.example.foodapp.controller;

import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.model.entities.User;
import com.example.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/update", consumes = "application/json")
    public String addRating(@RequestBody User updatedUser){

        if(updatedUser.getUserId()!=null){

            User user = userRepository.findById(updatedUser.getUserId()).orElse(null);

            if(user!=null){
                if(updatedUser.getUserName()!=null){
                    user.setUserName(updatedUser.getUserName());
                }
                if(updatedUser.getAddress()!=null){
                    user.setAddress(updatedUser.getAddress());
                }
                if(updatedUser.getPhone()!=null){
                    user.setPhone(updatedUser.getPhone());
                }
                if(updatedUser.getPassword()!=null){
                    user.setPassword(updatedUser.getPassword());
                }

            }

            userRepository.save(user);

        }
        return "User details updated";

    }
}
