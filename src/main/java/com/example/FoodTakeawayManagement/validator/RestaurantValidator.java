package com.example.FoodTakeawayManagement.validator;

import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.service.restaurant.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RestaurantValidator {

    private RestaurantService restaurantService;

    // Make a function that checks if the ordered food is in the manu of the restaurant
    public void foodIsInMenu(List<Long> foods, long restaurantId) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        List<Food> menu = restaurant.getMenu();
        for(long food : foods) {
            restaurant.getMenu();
        }
    }
}
