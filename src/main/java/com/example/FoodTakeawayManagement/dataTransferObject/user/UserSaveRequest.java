package com.example.FoodTakeawayManagement.dataTransferObject.user;

import com.example.FoodTakeawayManagement.model.user.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserSaveRequest {
    private String name;
    private String surName;
    private String email;
    private String phone;
    private String password;
    private Set<Role> roles;
}
