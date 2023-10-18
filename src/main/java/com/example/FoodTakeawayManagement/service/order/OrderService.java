package com.example.FoodTakeawayManagement.service.order;

import com.example.FoodTakeawayManagement.model.order.Order;
import com.example.FoodTakeawayManagement.model.order.OrderStatus;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> findAll();

    String updateAddress(long id, String address);

    OrderStatus updateOrderStatus(long id, OrderStatus orderStatus);

    Order findById(long id);

    void deleteById(long id);

}
