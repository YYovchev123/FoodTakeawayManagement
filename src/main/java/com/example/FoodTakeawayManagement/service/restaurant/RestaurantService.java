package com.example.FoodTakeawayManagement.service.restaurant;

import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.model.restaurant.RestaurantStatus;

import java.util.List;

public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    List<Restaurant> findAll();

    Restaurant update(long id, Restaurant updatedRestaurant);

    RestaurantStatus updateRestaurantStatus(long id, RestaurantStatus restaurantStatus);

    Restaurant findById(long id);

    void deleteById(long id);

    Food addToMenu(long restaurantId, Food food);
}
