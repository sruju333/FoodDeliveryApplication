package com.example.foodapp.controller;

import com.example.foodapp.model.request.OrderSaveRequest;
import com.example.foodapp.model.request.UpdateOrderStatusRequest;
import com.example.foodapp.model.response.OrderSaveResponse;
import com.example.foodapp.model.response.Response;
import com.example.foodapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService ordersService;

    @PostMapping("/place_order")
    public ResponseEntity<OrderSaveResponse> saveOrder(@RequestBody OrderSaveRequest orderSaveRequest){

        try{
            return ordersService.saveOrder(orderSaveRequest);
        }
        catch (Exception e){

            OrderSaveResponse orderSaveResponse = new OrderSaveResponse();
            orderSaveResponse.setStatus(false);
            orderSaveResponse.setMessage("Error Occurred!. Try Again!"+e.getMessage());
            return new ResponseEntity<OrderSaveResponse>(orderSaveResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update_status")
    public ResponseEntity<Response> updateOrderStatus(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest){

        try{
            return ordersService.updateOrderStatus(updateOrderStatusRequest);
        }
        catch (Exception e){

            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Error Occurred!. Try Again!"+e.getMessage());
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
