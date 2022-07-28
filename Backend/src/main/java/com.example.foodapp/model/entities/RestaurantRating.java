package com.example.foodapp.model.entities;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

//@Entity
//@Table(name = "restaurant_ratings")
@Document("restaurant_ratings")
public class RestaurantRating {

    @Id
    private Long id;

    private Long restaurantId;

    private Integer rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
