package com.example.foodapp.controller;

import com.example.foodapp.model.entities.Product;
import com.example.foodapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product).getMessage();
    }

    @PostMapping("/product/update")
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product).getMessage();
    }
}
