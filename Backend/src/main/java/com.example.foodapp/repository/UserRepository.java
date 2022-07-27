package com.example.foodapp.repository;

import com.example.foodapp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    User findByJwt(String jwt);
}
