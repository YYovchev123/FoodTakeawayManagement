package com.example.FoodTakeawayManagement.converter;

import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderSaveRequest;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.order.Order;
import com.example.FoodTakeawayManagement.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderConverter {

    private final FoodConverter foodConverter;
    private UserService userService;
    public Order convert(OrderSaveRequest orderSaveRequest) {
        return Order.builder()
                .restaurant(orderSaveRequest.getRestaurant())
                .foods(orderSaveRequest.getFoods().stream().map(foodConverter::convert).collect(Collectors.toList()))
                .user(userService.findById(orderSaveRequest.getUser()))
                .address(orderSaveRequest.getAddress())
                .price(orderSaveRequest.getPrice())
                .orderStatus(orderSaveRequest.getOrderStatus())
                .deliveryWay(orderSaveRequest.getDeliveryWay())
                .paymentMethod(orderSaveRequest.getPaymentMethod())
                .build();
    }

    public OrderResponse convert(Order order) {
        return OrderResponse.builder()
                .restaurant(order.getRestaurant())
                .foods(order.getFoods().stream().map(foodConverter::convert).collect(Collectors.toList()))
                .user(order.getUser())
                .address(order.getAddress())
                .price(order.getPrice())
                .orderStatus(order.getOrderStatus())
                .deliveryWay(order.getDeliveryWay())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }
}
