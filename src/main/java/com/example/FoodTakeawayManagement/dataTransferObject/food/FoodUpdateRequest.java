package com.example.FoodTakeawayManagement.dataTransferObject.food;

import com.example.FoodTakeawayManagement.model.food.FoodCategory;
import com.example.FoodTakeawayManagement.model.food.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FoodUpdateRequest {
    private String name;
    private String image;
    private float price;
    private String description;
    private FoodType foodType;
    private FoodCategory foodCategory;
    private String ingredients;
}
