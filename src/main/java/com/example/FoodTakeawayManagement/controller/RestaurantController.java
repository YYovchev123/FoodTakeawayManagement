package com.example.FoodTakeawayManagement.controller;

import com.example.FoodTakeawayManagement.converter.RatingConverter;
import com.example.FoodTakeawayManagement.converter.RestaurantConverter;
import com.example.FoodTakeawayManagement.dataTransferObject.rating.RatingResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.restaurant.RestaurantResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.restaurant.RestaurantSaveRequest;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Rating;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.service.food.FoodService;
import com.example.FoodTakeawayManagement.service.restaurant.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;
    private RestaurantConverter restaurantConverter;
    private RatingConverter ratingConverter;
    private FoodService foodService;

    // Make sure only certain people can use this function
    @PostMapping
    public ResponseEntity<RestaurantResponse> save(@RequestBody RestaurantSaveRequest restaurantSaveRequest) {
        Restaurant restaurant = restaurantConverter.convert(restaurantSaveRequest);
        Restaurant savedRestaurant = restaurantService.save(restaurant);
        RestaurantResponse restaurantResponse = restaurantConverter.convert(savedRestaurant);
        return ResponseEntity.ok(restaurantResponse);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> findAll() {
        List<Restaurant> restaurants = restaurantService.findAll();
        List<RestaurantResponse> restaurantResponses = restaurants.stream().map(restaurantConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok(restaurantResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantResponse> getById(@PathVariable long id) {
        Restaurant restaurant = restaurantService.findById(id);
        ///
        System.out.println(restaurant.getMenu());
        ///
        RestaurantResponse restaurantResponse = restaurantConverter.convert(restaurant);
        return ResponseEntity.ok(restaurantResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        restaurantService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/rating/{id}")
    public ResponseEntity<Integer> getRating(@PathVariable long id) {
         return ResponseEntity.ok(restaurantService.getRating(id));
    }

    @GetMapping(value = "/ratings/{id}")
    public ResponseEntity<List<RatingResponse>> getRatings(@PathVariable long id) {
        List<Rating> ratings = restaurantService.getRatings(id);
        List<RatingResponse> ratingResponses = ratings.stream().map(ratingConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok(ratingResponses);
    }

    @PutMapping(value = "/{foodId}/{restaurantId}")
    public ResponseEntity<RestaurantResponse> addToMenu(@PathVariable long foodId, @PathVariable long restaurantId) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        Food food = foodService.findById(foodId);
        restaurantService.addFoodToMenu(restaurantId, food);
        RestaurantResponse restaurantResponse = restaurantConverter.convert(restaurant);
        return ResponseEntity.ok(restaurantResponse);
    }

}
