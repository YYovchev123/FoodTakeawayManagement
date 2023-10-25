package com.example.FoodTakeawayManagement.service.restaurant;

import com.example.FoodTakeawayManagement.exception.RecordBadRequestException;
import com.example.FoodTakeawayManagement.exception.RecordNotFoundException;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Rating;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.model.restaurant.RestaurantStatus;
import com.example.FoodTakeawayManagement.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    // Make this function only available for restaurant owner
    @Override
    public Restaurant update(long id, Restaurant updatedRestaurant) {
        Restaurant restaurant = findById(id);
        if(updatedRestaurant.getName() != null) {
            restaurant.setName(updatedRestaurant.getName());
        }
        if(updatedRestaurant.getLocation() != null) {
            restaurant.setLocation(updatedRestaurant.getLocation());
        }
        if(updatedRestaurant.getEmail() != null) {
            restaurant.setEmail(updatedRestaurant.getEmail());
        }
        if(updatedRestaurant.getPhone() != null) {
            restaurant.setPhone(updatedRestaurant.getPhone());
        }
        if(updatedRestaurant.getLogoImage() != null) {
            restaurant.setLogoImage(updatedRestaurant.getLogoImage());
        }
        if(updatedRestaurant.getImage() != null) {
            restaurant.setImage(updatedRestaurant.getImage());
        }
        if(updatedRestaurant.getRestaurantCategory() != null) {
            restaurant.setRestaurantCategory(updatedRestaurant.getRestaurantCategory());
        }
        return restaurant;
    }

    // Automate this function after a certain time it changes automatically
    @Override
    public RestaurantStatus updateRestaurantStatus(long id, RestaurantStatus restaurantStatus) {
        Restaurant restaurant = findById(id);
        if(restaurant.getRestaurantStatus() == restaurantStatus) {
            throw new RecordBadRequestException("Can't change to the same restaurant status");
        }
        restaurant.setRestaurantStatus(restaurantStatus);
        return restaurantStatus;
    }

    @Override
    public Restaurant findById(long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Restaurant with id:%s, not found")));
    }

    @Override
    public int getRating(long id) {
        Restaurant restaurant = findById(id);
        return restaurant.getRating();
    }

    @Override
    public List<Rating> getRatings(long id) {
        Restaurant restaurant = findById(id);
        return restaurant.getRatings();
    }

    @Override
    public void deleteById(long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Food addFoodToMenu(long restaurantId, Food food) {
        Restaurant restaurant = findById(restaurantId);
        restaurant.addToMenu(food);
        return food;
    }
}
