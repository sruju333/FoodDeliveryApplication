package com.example.foodapp.service;

import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.entities.Restaurant;
import com.example.foodapp.repository.ProductRepository;
import com.example.foodapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getALlItems(long RId){
        List<Product> AllItems=productRepository.findById(RId);
       return AllItems;
    }
}
