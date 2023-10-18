package com.example.FoodTakeawayManagement.dataTransferObject.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserUpdateRequest {
    private String name;
    private String surName;
    private String email;
    private String phone;
}
