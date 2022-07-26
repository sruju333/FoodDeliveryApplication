package com.example.foodapp.service;

import com.example.foodapp.model.entities.Product;
import com.example.foodapp.model.response.Response;
import com.example.foodapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Response addProduct(Product product){

        Response response = new Response(true,"Added Product Successfully");
        productRepository.save(product);
        return response;
    }

    public Response updateProduct(Product updatedProduct){
        long productId=updatedProduct.getProductId();
        Product product= productRepository.findById(productId);
        Response response = new Response(true,"Product Details Updated Successfully");
        if(updatedProduct.getProductName()!=null)
            product.setProductName(updatedProduct.getProductName());
        if(updatedProduct.getPrice()!=null)
            product.setPrice(updatedProduct.getPrice());
        if(updatedProduct.getVeg()!=null)
            product.setVeg(updatedProduct.getVeg());
        if(updatedProduct.getAvailable()!=null)
            product.setAvailable(updatedProduct.getAvailable());
        if(updatedProduct.getDiscount()!=null)
            product.setDiscount(updatedProduct.getDiscount());
        if(updatedProduct.getProductImage()!=null)
            product.setProductImage(updatedProduct.getProductImage());

        productRepository.save(product);
        return response;
    }

}
