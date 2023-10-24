package com.example.FoodTakeawayManagement.dataTransferObject.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSaveRequest {
    private String name;
    private String surName;
    private String email;
    private String phone;
    private String password;
    private String role;
}
