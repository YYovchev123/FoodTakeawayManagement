package com.example.FoodTakeawayManagement.service.rating;

import com.example.FoodTakeawayManagement.model.restaurant.Rating;

import java.util.List;

public interface RatingService {

//    Rating save(Rating rating);

    List<Rating> findAll();

    Rating findById(long id);

    void deleteById(long id);

    int rate(long restaurantId, Rating rating);
}
