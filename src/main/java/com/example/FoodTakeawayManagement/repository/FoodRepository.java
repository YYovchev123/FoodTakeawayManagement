package com.example.FoodTakeawayManagement.repository;

import com.example.FoodTakeawayManagement.model.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
