package com.example.FoodTakeawayManagement.service.user;

import com.example.FoodTakeawayManagement.model.user.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User update(long id, User updatedUser);

    void resetPassword(String newPassword, String currentPassword, String email);

    User findById(long id);

    User findByEmail(String email);

    void deleteById(long id);
}
