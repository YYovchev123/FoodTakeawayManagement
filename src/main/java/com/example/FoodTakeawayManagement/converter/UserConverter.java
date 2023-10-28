package com.example.FoodTakeawayManagement.converter;

import com.example.FoodTakeawayManagement.dataTransferObject.user.UserResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.user.UserSaveRequest;
import com.example.FoodTakeawayManagement.model.user.Role;
import com.example.FoodTakeawayManagement.model.user.User;
import com.example.FoodTakeawayManagement.service.role.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConverter {

    private RoleService roleService;

    public User convert(UserSaveRequest userSaveRequest) {

        Role role = roleService.findByRole(userSaveRequest.getRole());

        return User.builder()
                .name(userSaveRequest.getName())
                .surName(userSaveRequest.getSurName())
                .email(userSaveRequest.getEmail())
                .phone(userSaveRequest.getPhone())
                .password(userSaveRequest.getPassword())
                .role(role)
                .build();
    }

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surName(user.getSurName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole().getRole())
                .build();
    }
}
