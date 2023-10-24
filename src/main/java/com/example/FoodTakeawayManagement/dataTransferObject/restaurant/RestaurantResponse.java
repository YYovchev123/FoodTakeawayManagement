package com.example.FoodTakeawayManagement.dataTransferObject.restaurant;

import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodResponse;
import com.example.FoodTakeawayManagement.model.restaurant.RestaurantCategory;
import com.example.FoodTakeawayManagement.model.restaurant.RestaurantStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RestaurantResponse {
    private String name;
    private String location;
    private String email;
    private String phone;
    private String logoImage;
    private String image;
    private List<FoodResponse> menu;
    private RestaurantCategory restaurantCategory;
    private RestaurantStatus restaurantStatus;
}
