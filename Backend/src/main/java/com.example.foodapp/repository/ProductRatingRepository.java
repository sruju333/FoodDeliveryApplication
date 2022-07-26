package com.example.foodapp.repository;

import com.example.foodapp.model.entities.ProductRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRatingRepository  extends JpaRepository<ProductRating, Long> {


}
