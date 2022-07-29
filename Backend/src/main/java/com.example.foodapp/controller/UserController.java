package com.example.foodapp.controller;
import com.example.foodapp.model.entities.User;
import com.example.foodapp.model.request.SignUpUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.foodapp.model.request.LoginRequest;
import com.example.foodapp.model.response.SignUpResponse;
import com.example.foodapp.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //ToDo: Import Response
    @PostMapping(value = "/signup")
    public SignUpResponse signUpCustomer(@RequestBody SignUpUserRequest signUpUserRequest) {

        return userService.register(signUpUserRequest);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<SignUpResponse> login(@RequestBody LoginRequest loginRequest) {

        try {
            SignUpResponse loginResponse = userService.authenticate(loginRequest);
            if (loginResponse.isStatus()) {
                return new ResponseEntity<SignUpResponse>(loginResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<SignUpResponse>(loginResponse, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            SignUpResponse loginResponse = new SignUpResponse();
            loginResponse.setStatus(false);
            loginResponse.setMessage("Try Again");
            return new ResponseEntity<SignUpResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    @PostMapping(value = "/update", consumes = "application/json")
    public String updateUser(@RequestBody User updatedUser){

        return userService.updateUser(updatedUser);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserDetails(id));

    }
}