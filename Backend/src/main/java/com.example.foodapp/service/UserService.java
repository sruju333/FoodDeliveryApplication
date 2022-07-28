package com.example.foodapp.service;

import com.example.foodapp.enumclasses.UserRole;
import com.example.foodapp.model.entities.User;
import com.example.foodapp.model.request.LoginRequest;
import com.example.foodapp.model.request.SignUpUserRequest;
import com.example.foodapp.model.response.SignUpResponse;
import com.example.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${pepper}")
    private String pepper;

    public SignUpResponse register(SignUpUserRequest signUpUserRequest){

        //first check if already exist or not
        SignUpResponse signUpResponse = new SignUpResponse();
        if(userRepository.findByEmail(signUpUserRequest.getEmail())!=null) {
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("SignUp failed! Already Registered. Please sign in");
            return signUpResponse;
        }

        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(signUpUserRequest.getPassword()+pepper,salt);
        signUpUserRequest.setPassword(hashedPassword);
        signUpUserRequest.setSalt(salt);

        String jwt = BCrypt.hashpw(signUpUserRequest.getUserName()+ Instant.now().getEpochSecond(),salt);
        signUpUserRequest.setJwt(jwt);

        User user = new User();
        user.setPassword(signUpUserRequest.getPassword());
        user.setUserName(signUpUserRequest.getUserName());
        user.setAddress(signUpUserRequest.getAddress());
        user.setPhone(signUpUserRequest.getPhone());
        user.setEmail(signUpUserRequest.getEmail());
        user.setRole(UserRole.valueOf(signUpUserRequest.getRole()));
        user.setJwt(signUpUserRequest.getJwt());
        user.setSalt(signUpUserRequest.getSalt());

        User newUser = userRepository.save(user);

        if(newUser == null){
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("SignUp failed");
        }
        else {
            signUpResponse.setJwt(jwt);
            signUpResponse.setStatus(true);
            signUpResponse.setMessage("SignUp successful");
        }

        return signUpResponse;
    }

    public  SignUpResponse authenticate(LoginRequest loginRequest) {
        User u = userRepository.findByEmail(loginRequest.getEmail());
        SignUpResponse loginResponse = new SignUpResponse();
        if(u==null){
            loginResponse.setStatus(false);
            loginResponse.setMessage("Invalid Email Id. User does not exist");
        }
        else{
            if(u.getPassword().equals(BCrypt.hashpw(loginRequest.getPassword()+pepper,u.getSalt()))){
                loginResponse.setStatus(true);
                loginResponse.setJwt(u.getJwt());
                loginResponse.setMessage("Login Successful");
            }
            else{
                loginResponse.setStatus(false);
                loginResponse.setMessage("Invalid Username or Password");
            }
        }

        return loginResponse;
    }

    public String updateUser(User updatedUser){
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
