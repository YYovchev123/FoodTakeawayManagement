package com.example.FoodTakeawayManagement.converter;

import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderSaveRequest;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.order.Order;
import com.example.FoodTakeawayManagement.model.order.OrderStatus;
import com.example.FoodTakeawayManagement.service.food.FoodService;
import com.example.FoodTakeawayManagement.service.restaurant.RestaurantService;
import com.example.FoodTakeawayManagement.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderConverter {

    private final FoodConverter foodConverter;
    private FoodService foodService;
    private UserService userService;
    private RestaurantService restaurantService;

    public Order convert(OrderSaveRequest orderSaveRequest) {
        // Check if this works
        List<Food> foods = new ArrayList<>();
        float price = 0;
        for(Long food : orderSaveRequest.getFoods()) {
            Food foodFound = foodService.findById(food);
            foods.add(foodFound);
        }
        for(Long food : orderSaveRequest.getFoods()) {
            Food foodFound = foodService.findById(food);
            price += foodFound.getPrice();
        }

        return Order.builder()
                .restaurant(restaurantService.findById(orderSaveRequest.getRestaurant()))
                .foods(foods)
                .user(userService.findById(orderSaveRequest.getUser()))
                .price(price)
                .orderStatus(OrderStatus.IN_PROCESS)
                .address(orderSaveRequest.getAddress())
                .deliveryWay(orderSaveRequest.getDeliveryWay())
                .paymentMethod(orderSaveRequest.getPaymentMethod())
                .build();
    }

    public OrderResponse convert(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
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
