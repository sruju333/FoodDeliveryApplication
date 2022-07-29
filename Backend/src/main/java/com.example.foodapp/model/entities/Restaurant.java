package com.example.foodapp.model.entities;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

//@Entity
//@Table(name = "restaurants")
@Document("restaurants")
public class Restaurant {

    @Id
    private Long id;
    private String restaurantAddress;
    private String restaurantName;
    private Long restaurantManagerId;
    private String restaurantImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Long getRestaurantManagerId() {
        return restaurantManagerId;
    }

    public void setRestaurantManagerId(Long restaurantManagerId) {
        this.restaurantManagerId = restaurantManagerId;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }
}
