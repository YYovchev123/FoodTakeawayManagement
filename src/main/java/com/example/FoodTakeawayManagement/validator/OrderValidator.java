package com.example.FoodTakeawayManagement.validator;

import com.example.FoodTakeawayManagement.exception.RecordBadRequestException;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.service.restaurant.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderValidator {

    private RestaurantService restaurantService;

    public void foodIsInMenu(List<Food> foods, long restaurantId) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        List<Food> menu = restaurant.getMenu();

        for (Food food: foods) {
            if(!menu.contains(food)) {
                throw new RecordBadRequestException(String.format("%s is not in the menu", food.getName()));
            }
        }
    }
}
