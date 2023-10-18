package com.example.FoodTakeawayManagement.service.user;

import com.example.FoodTakeawayManagement.exception.RecordNotFoundException;
import com.example.FoodTakeawayManagement.model.user.User;
import com.example.FoodTakeawayManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Make this function
    @Override
    public User update(long id, User updatedUser) {
        User user = findById(id);
        if(updatedUser.getName() != null) {
            user.setName(updatedUser.getName());
        }
        if(updatedUser.getSurName() != null) {
            user.setSurName(updatedUser.getSurName());
        }
        if(updatedUser.getEmail() != null) {
            user.setEmail(updatedUser.getEmail());
        }
        if(updatedUser.getPhone() != null) {
            user.setPhone(updatedUser.getPhone());
        }

        return user;
    }

    // Finnish this function when spring security and bCryptPasswordEncoder is implemented !!!
    @Override
    public void resetPassword(String newPassword, String currentPassword, String email) {
        User user = findByEmail(email);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("User with id:%s, not found")));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RecordNotFoundException(String.format("User with email:%s, not found")));
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
