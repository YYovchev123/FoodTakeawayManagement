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
    private long restaurant;
    private List<Long> foods;
    private long user;
    private String address;
    private DeliveryWay deliveryWay;
    private PaymentMethod paymentMethod;
}
