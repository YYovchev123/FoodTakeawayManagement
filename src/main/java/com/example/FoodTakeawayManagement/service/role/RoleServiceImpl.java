package com.example.FoodTakeawayManagement.service.role;

import com.example.FoodTakeawayManagement.exception.RecordNotFoundException;
import com.example.FoodTakeawayManagement.model.user.Role;
import com.example.FoodTakeawayManagement.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByRole(String userRole) {
        return roleRepository.findByRole(userRole).orElseThrow(() -> new RecordNotFoundException(String.format("Role with name:%s, not found", userRole)));
    }
}
