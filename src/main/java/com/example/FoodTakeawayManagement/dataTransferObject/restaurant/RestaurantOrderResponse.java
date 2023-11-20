package com.example.FoodTakeawayManagement.dataTransferObject.restaurant;

import com.example.FoodTakeawayManagement.model.restaurant.RestaurantCategory;
import com.example.FoodTakeawayManagement.model.restaurant.RestaurantStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RestaurantOrderResponse {
    private long id;
    private String name;
    private String location;
    private String email;
    private String phone;
    private RestaurantCategory restaurantCategory;
    private RestaurantStatus restaurantStatus;
}
