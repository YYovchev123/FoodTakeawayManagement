package com.example.FoodTakeawayManagement.controller;

import com.example.FoodTakeawayManagement.converter.RatingConverter;
import com.example.FoodTakeawayManagement.dataTransferObject.rating.RatingResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.rating.RatingSaveRequest;
import com.example.FoodTakeawayManagement.model.restaurant.Rating;
import com.example.FoodTakeawayManagement.service.rating.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/ratings")
public class RatingController {

    private RatingService ratingService;
    private RatingConverter ratingConverter;

    // Make sure only the people that have ordered can rate | One person can rate only once for every restaurant
    @PostMapping(value = "/{id}")
    public ResponseEntity<RatingResponse> rateRestaurant(@PathVariable long id, @RequestBody RatingSaveRequest ratingSaveRequest) {
        Rating rating = ratingConverter.convert(ratingSaveRequest);
        Rating rate = ratingService.rate(id, rating);
        RatingResponse ratingResponse = ratingConverter.convert(rate);
        return ResponseEntity.ok(ratingResponse);
    }

    @GetMapping
    public ResponseEntity<List<RatingResponse>> findAll() {
        List<Rating> ratings = ratingService.findAll();
        List<RatingResponse> ratingResponses = ratings.stream().map(ratingConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok(ratingResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RatingResponse> getById(@PathVariable long id) {
        Rating rating = ratingService.findById(id);
        RatingResponse ratingResponse = ratingConverter.convert(rating);
        return ResponseEntity.ok(ratingResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        ratingService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
