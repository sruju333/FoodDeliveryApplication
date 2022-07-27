package com.example.foodapp.repository;

import com.example.foodapp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
<<<<<<< HEAD

    User findByEmail(String email);

=======
    User findByUserId(Long id);
>>>>>>> b8f10ad77250892cc2dabd874211605bd3f4f3d7
    User findByJwt(String jwt);
}
