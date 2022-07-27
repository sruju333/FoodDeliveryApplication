package com.example.foodapp.service;

import com.example.foodapp.enumclasses.OrderStatus;
import com.example.foodapp.enumclasses.UserRole;
import com.example.foodapp.model.entities.Order;
import com.example.foodapp.model.entities.User;
import com.example.foodapp.model.request.OrderSaveRequest;
import com.example.foodapp.model.request.UpdateOrderStatusRequest;
import com.example.foodapp.model.response.OrderSaveResponse;
import com.example.foodapp.model.response.Response;
import com.example.foodapp.repository.OrderRepository;
import com.example.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository ordersRepository;

    @Autowired
    UserRepository usersRepository;

    public ResponseEntity<OrderSaveResponse> saveOrder(OrderSaveRequest orderSaveRequest){

        OrderSaveResponse orderSaveResponse = new OrderSaveResponse();
        User user = usersRepository.findById(orderSaveRequest.getUserId()).orElse(null);
        if(user==null){
            orderSaveResponse.setStatus(false);
            orderSaveResponse.setMessage("Invalid user id. User does not exist");
            return new ResponseEntity<>(orderSaveResponse, HttpStatus.NOT_FOUND);
        }
        else if(user.getRole()!= UserRole.CUSTOMER){
            orderSaveResponse.setStatus(false);
            orderSaveResponse.setMessage("Invalid user id. Only customers can place orders");
            return new ResponseEntity<>(orderSaveResponse,HttpStatus.UNAUTHORIZED);
        } else if (orderSaveRequest.getJwt()== user.getJwt()) {
            orderSaveResponse.setStatus(false);
            orderSaveResponse.setMessage("Invalid token");
            return new ResponseEntity<>(orderSaveResponse,HttpStatus.UNAUTHORIZED);
        } else{

            Order order = new Order();
            order.setProducts(orderSaveRequest.getProducts());
            order.setUserId(orderSaveRequest.getUserId());
            order.setOrderStatus(OrderStatus.valueOf(orderSaveRequest.getOrderStatus()));
            order.setDeliveryAddress(orderSaveRequest.getDeliveryAddress());
            order.setPaymentStatus(orderSaveRequest.getPaymentStatus());
            order.setPrice(orderSaveRequest.getPrice());
            order.setRestaurantId(orderSaveRequest.getRestaurantId());

            Order newOrder= ordersRepository.save(order);

            if(newOrder!=null){
                orderSaveResponse.setStatus(true);
                orderSaveResponse.setMessage("Order placed successfully");
                orderSaveResponse.setOrderId(newOrder.getOrderId());
                return new ResponseEntity<>(orderSaveResponse, HttpStatus.OK);
            }
            else{
                orderSaveResponse.setStatus(false);
                orderSaveResponse.setMessage("Unable to place order. Some error Occurred");
                return new ResponseEntity<>(orderSaveResponse,HttpStatus.BAD_REQUEST);
            }

        }

    }

    public ResponseEntity<Response> updateOrderStatus(UpdateOrderStatusRequest updateOrderStatusRequest){

        Response response = new Response();
        User user = usersRepository.findByJwt(updateOrderStatusRequest.getJwt());

        if(user==null){
            response.setStatus(false);
            response.setMessage("Invalid token. User does not exist");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        else if(user.getRole()==UserRole.CUSTOMER){
            response.setStatus(false);
            response.setMessage("Token.  Customers cannot update order status");
            return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
        } else{

            Order order = ordersRepository.findByOrderId(updateOrderStatusRequest.getOrderId());
            order.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getOrderStatus()));
            Order newOrder= ordersRepository.save(order);

            if(newOrder!=null){
                response.setStatus(true);
                response.setMessage("Order status updated successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else{
                response.setStatus(false);
                response.setMessage("Unable to update order status. Some error Occurred");
                return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
            }

        }


    }

}
