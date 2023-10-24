package com.example.FoodTakeawayManagement.repository;

import com.example.FoodTakeawayManagement.model.user.Role;
import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, LineNumberGen> {

    Optional<Role> findByRole(String role);
}
