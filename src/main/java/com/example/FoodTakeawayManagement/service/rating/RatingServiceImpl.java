package com.example.FoodTakeawayManagement.service.rating;

import com.example.FoodTakeawayManagement.exception.RecordNotFoundException;
import com.example.FoodTakeawayManagement.model.restaurant.Rating;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.repository.RatingRepository;
import com.example.FoodTakeawayManagement.service.restaurant.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    private RestaurantService restaurantService;

//    @Override
//    public Rating save(Rating rating) {
//        return ratingRepository.save(rating);
//    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findById(long id) {
        return ratingRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Rating with id:%s, not found")));
    }

    @Override
    public void deleteById(long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public int rate(long restaurantId, Rating rating) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        restaurant.rate(rating);
        return rating.getRating();
    }

}
