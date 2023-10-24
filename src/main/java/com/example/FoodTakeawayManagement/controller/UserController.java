package com.example.FoodTakeawayManagement.controller;

import com.example.FoodTakeawayManagement.converter.UserConverter;
import com.example.FoodTakeawayManagement.dataTransferObject.user.UserResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.user.UserSaveRequest;
import com.example.FoodTakeawayManagement.model.user.User;
import com.example.FoodTakeawayManagement.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private UserConverter userConverter;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserSaveRequest userSaveRequest) {
        // Send them an email after registering
        User user = userConverter.convert(userSaveRequest);
        User savedUser = userService.save(user);
        UserResponse userResponse = userConverter.convert(savedUser);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> users = userService.findAll();
        List<UserResponse> userResponses = users.stream().map(userConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable long id) {
        User user = userService.findById(id);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
