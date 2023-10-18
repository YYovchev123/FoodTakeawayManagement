package com.example.FoodTakeawayManagement.service.food;

import com.example.FoodTakeawayManagement.exception.RecordNotFoundException;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService{

    private FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    // Make this function only available for specific users / restaurant account
    @Override
    public Food update(long id, Food updatedFood) {
        Food food = findById(id);
        if(updatedFood.getName() != null) {
            food.setName(updatedFood.getName());
        }
        if(updatedFood.getImage() != null) {
            food.setImage(updatedFood.getImage());
        }
        if(updatedFood.getPrice() > 0) {
            food.setPrice(updatedFood.getPrice());
        }
        if(updatedFood.getDescription() != null) {
            food.setDescription(updatedFood.getDescription());
        }
        if(updatedFood.getFoodType() != null) {
            food.setFoodType(updatedFood.getFoodType());
        }
        if(updatedFood.getFoodCategory() != null) {
            food.setFoodCategory(updatedFood.getFoodCategory());
        }
        if(updatedFood.getIngredients() != null) {
            food.setIngredients(updatedFood.getIngredients());
        }

        return food;
    }

    @Override
    public Food findById(long id) {
        return foodRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Food with id: %s, not found", id)));
    }

    @Override
    public void deleteById(long id) {
        foodRepository.deleteById(id);
    }
}
