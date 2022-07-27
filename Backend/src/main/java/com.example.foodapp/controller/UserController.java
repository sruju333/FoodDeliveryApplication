package com.example.foodapp.controller;
import com.example.foodapp.model.entities.User;
import com.example.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.example.foodapp.model.entities.User;
import com.example.foodapp.model.request.LoginRequest;
import com.example.foodapp.model.response.SignUpResponse;
import com.example.foodapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //ToDo: Import Response
    @PostMapping(value = "/signup")
    public SignUpResponse signUpCustomer(@RequestBody User user){

        return userService.register(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<SignUpResponse> login(@RequestBody LoginRequest loginRequest){

        try{
            SignUpResponse loginResponse = userService.authenticate(loginRequest);
            if(loginResponse.isStatus()){
                return new ResponseEntity<SignUpResponse>(loginResponse, HttpStatus.OK);
            }else {
                return new ResponseEntity<SignUpResponse>(loginResponse,HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            SignUpResponse loginResponse =  new SignUpResponse();
            loginResponse.setStatus(false);
            loginResponse.setMessage("Try Again");
            return new ResponseEntity<SignUpResponse>(loginResponse,HttpStatus.INTERNAL_SERVER_ERROR);

        }
=======
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

>>>>>>> b8f10ad77250892cc2dabd874211605bd3f4f3d7
    }
}
