package com.example.FoodTakeawayManagement.controller;

import com.example.FoodTakeawayManagement.converter.FoodConverter;
import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.food.FoodSaveRequest;
import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.service.food.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/foods")
public class FoodController {

    private FoodService foodService;
    private FoodConverter foodConverter;

    @PostMapping
    public ResponseEntity<FoodResponse> saveFood(@RequestBody FoodSaveRequest foodSaveRequest) {
        Food food = foodConverter.convert(foodSaveRequest);
        Food savedFood = foodService.save(food);
        FoodResponse foodResponse = foodConverter.convert(savedFood);
        return ResponseEntity.ok(foodResponse);
    }

    @GetMapping
    public ResponseEntity<List<FoodResponse>> findAll() {
        List<Food> foods = foodService.findAll();
        List<FoodResponse> foodResponses = foods.stream().map(foodConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok(foodResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FoodResponse> getById(@PathVariable long id) {
        Food foundFood = foodService.findById(id);
        FoodResponse foodResponse = foodConverter.convert(foundFood);
        return ResponseEntity.ok(foodResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        foodService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
