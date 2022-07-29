package com.example.foodapp.model.entities;

import com.example.foodapp.enumclasses.OrderStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashMap;
import javax.persistence.Id;
//@Entity
//@Table(name = "orders")
@Document("orders")
public class Order {

    @Id
    private Long id;

    private @NonNull Long userId;

    private HashMap<Long, Integer> products;

    private float price;
    private Boolean paymentStatus;

    private String orderStatus;

    @CreationTimestamp
    private Date date;

    private String deliveryAddress;

    private Long restaurantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    public HashMap<Long, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Long, Integer> products) {
        this.products = products;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
