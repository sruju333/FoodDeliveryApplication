package com.example.foodapp.repository;

import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
>>>>>>> b8f10ad77250892cc2dabd874211605bd3f4f3d7
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByRestaurantId(long restaurantId);
    Product findByProductId(long productId);

}
