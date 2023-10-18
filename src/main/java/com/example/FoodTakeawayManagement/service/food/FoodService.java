package com.example.FoodTakeawayManagement.service.food;

import com.example.FoodTakeawayManagement.model.food.Food;

import java.util.List;

public interface FoodService {

    Food save(Food food);

    List<Food> findAll();

    Food update(long id, Food updatedFood);

    Food findById(long id);

    void deleteById(long id);
}
