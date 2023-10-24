package com.example.FoodTakeawayManagement.dataTransferObject.restaurant;

import com.example.FoodTakeawayManagement.model.restaurant.RestaurantCategory;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RestaurantSaveRequest {
    private String name;
    private String location;
    private String email;
    private String phone;
    private String logoImage;
    private String image;
    private List<Long> menu;
    private RestaurantCategory restaurantCategory;
}
