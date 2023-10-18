package com.example.FoodTakeawayManagement.dataTransferObject.food;

import com.example.FoodTakeawayManagement.model.food.FoodCategory;
import com.example.FoodTakeawayManagement.model.food.FoodType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodSaveRequest {
    private String name;
    private String image;
    private float price;
    private String description;
    private FoodType foodType;
    private FoodCategory foodCategory;
    private String ingredients;
}
