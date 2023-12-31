package com.example.FoodTakeawayManagement.dataTransferObject.order;

import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.restaurant.RestaurantOrderResponse;
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
    private long id;
    private RestaurantOrderResponse restaurant;
    private List<FoodResponse> foods;
    private User user;
    private String address;
    private float price;
    private OrderStatus orderStatus;
    private DeliveryWay deliveryWay;
    private PaymentMethod paymentMethod;
}
