package com.example.FoodTakeawayManagement.service.order;

import com.example.FoodTakeawayManagement.exception.RecordBadRequestException;
import com.example.FoodTakeawayManagement.exception.RecordNotFoundException;
import com.example.FoodTakeawayManagement.model.order.Order;
import com.example.FoodTakeawayManagement.model.order.OrderStatus;
import com.example.FoodTakeawayManagement.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }


    @Override
    public String updateAddress(long id, String address) {
        Order order = findById(id);
        if(order.getOrderStatus() == OrderStatus.ON_WAY || order.getOrderStatus() == OrderStatus.DELIVERED) {
            throw new RecordBadRequestException("Can't update address because order is either delivered or on it's way");
        }
        order.setAddress(address);
        return address;
    }

    // Make this function only available for certain users
    @Override
    public OrderStatus updateOrderStatus(long id, OrderStatus orderStatus) {
        Order order = findById(id);
        order.setOrderStatus(orderStatus);
        return orderStatus;
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Order with id: %s, not found", id)));
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }
}
