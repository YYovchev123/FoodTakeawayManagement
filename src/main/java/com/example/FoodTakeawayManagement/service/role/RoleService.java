package com.example.FoodTakeawayManagement.service.role;

import com.example.FoodTakeawayManagement.model.user.Role;

public interface RoleService {

    Role save(Role role);

    Role findByRole(String userRole);
}
