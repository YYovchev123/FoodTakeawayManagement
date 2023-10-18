package com.example.FoodTakeawayManagement.dataTransferObject.order;

import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.order.DeliveryWay;
import com.example.FoodTakeawayManagement.model.order.OrderStatus;
import com.example.FoodTakeawayManagement.model.order.PaymentMethod;
import com.example.FoodTakeawayManagement.model.user.User;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private Restaurant restaurant;
    private List<Food> foods;
    private User user;
    private String address;
    private float price;
    private OrderStatus orderStatus;
    private DeliveryWay deliveryWay;
    private PaymentMethod paymentMethod;
}
