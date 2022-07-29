package com.example.foodapp.repository;

import com.example.foodapp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {

    User findByEmail(String email);
    User findByJwt(String jwt);
}
