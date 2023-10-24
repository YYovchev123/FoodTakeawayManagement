package com.example.FoodTakeawayManagement.dataTransferObject.order;

import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodSaveRequest;
import com.example.FoodTakeawayManagement.model.order.DeliveryWay;
import com.example.FoodTakeawayManagement.model.order.OrderStatus;
import com.example.FoodTakeawayManagement.model.order.PaymentMethod;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderSaveRequest {
    private Restaurant restaurant;
    private List<FoodSaveRequest> foods;
    private long user;
    private String address;
    private float price;
    private OrderStatus orderStatus;
    private DeliveryWay deliveryWay;
    private PaymentMethod paymentMethod;
}
