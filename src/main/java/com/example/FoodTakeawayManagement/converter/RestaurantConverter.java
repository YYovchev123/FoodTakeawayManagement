package com.example.FoodTakeawayManagement.converter;

import com.example.FoodTakeawayManagement.dataTransferObject.restaurant.RestaurantOrderResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.restaurant.RestaurantResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.restaurant.RestaurantSaveRequest;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.service.food.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RestaurantConverter {

    private final FoodConverter foodConverter;
    private final RatingConverter ratingConverter;
    private FoodService foodService;

    public Restaurant convert(RestaurantSaveRequest restaurantSaveRequest) {
        List<Food> foods = new ArrayList<>();
        for(long id : restaurantSaveRequest.getMenu()) {
            Food food = foodService.findById(id);
            foods.add(food);
        }

        return Restaurant.builder()
                .name(restaurantSaveRequest.getName())
                .location(restaurantSaveRequest.getLocation())
                .email(restaurantSaveRequest.getEmail())
                .phone(restaurantSaveRequest.getPhone())
                .logoImage(restaurantSaveRequest.getLogoImage())
                .image(restaurantSaveRequest.getImage())
                .menu(foods)
                .restaurantCategory(restaurantSaveRequest.getRestaurantCategory())
                .build();
    }

    public RestaurantResponse convert(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .email(restaurant.getEmail())
                .phone(restaurant.getPhone())
                .logoImage(restaurant.getLogoImage())
                .image(restaurant.getImage())
                .rating(restaurant.getRating())
                .ratings(restaurant.getRatings())
                .menu(restaurant.getMenu().stream().map(foodConverter::convert).collect(Collectors.toList()))
                .restaurantCategory(restaurant.getRestaurantCategory())
                .restaurantStatus(restaurant.getRestaurantStatus())
                .build();
    }

    public RestaurantOrderResponse convertRestaurantOrder(Restaurant restaurant) {
        return RestaurantOrderResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .email(restaurant.getEmail())
                .phone(restaurant.getPhone())
                .restaurantCategory(restaurant.getRestaurantCategory())
                .restaurantStatus(restaurant.getRestaurantStatus())
                .build();
    }

}
