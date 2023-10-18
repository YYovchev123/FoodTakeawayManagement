package com.example.FoodTakeawayManagement.repository;

import com.example.FoodTakeawayManagement.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
