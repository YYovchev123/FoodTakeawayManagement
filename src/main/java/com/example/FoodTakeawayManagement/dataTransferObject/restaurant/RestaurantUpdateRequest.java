package com.example.FoodTakeawayManagement.dataTransferObject.restaurant;

import com.example.FoodTakeawayManagement.model.restaurant.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RestaurantUpdateRequest {
    private String name;
    private String location;
    private String email;
    private String phone;
    private String logoImage;
    private String image;
    private RestaurantCategory restaurantCategory;
}
