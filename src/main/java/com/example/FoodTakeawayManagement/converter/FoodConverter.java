package com.example.FoodTakeawayManagement.converter;

import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodSaveRequest;
import com.example.FoodTakeawayManagement.model.food.Food;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FoodConverter {

    public Food convert(FoodSaveRequest foodSaveRequest) {
        return Food.builder()
                .name(foodSaveRequest.getName())
                .image(foodSaveRequest.getImage())
                .price(foodSaveRequest.getPrice())
                .description(foodSaveRequest.getDescription())
                .foodType(foodSaveRequest.getFoodType())
                .foodCategory(foodSaveRequest.getFoodCategory())
                .ingredients(foodSaveRequest.getIngredients())
                .build();
    }

    public FoodResponse convert(Food food) {
        return FoodResponse.builder()
                .name(food.getName())
                .price(food.getPrice())
                .description(food.getDescription())
                .foodType(food.getFoodType())
                .foodCategory(food.getFoodCategory())
                .ingredients(food.getIngredients())
                .build();
    }
}
