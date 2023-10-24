package com.example.FoodTakeawayManagement.controller;

import com.example.FoodTakeawayManagement.converter.OrderConverter;
import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderAddressUpdate;
import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderSaveRequest;
import com.example.FoodTakeawayManagement.dataTransferObject.order.OrderStatusUpdate;
import com.example.FoodTakeawayManagement.model.order.Order;
import com.example.FoodTakeawayManagement.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderService orderService;
    private OrderConverter orderConverter;

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderSaveRequest orderSaveRequest) {
        Order order = orderConverter.convert(orderSaveRequest);
        Order savedOrder = orderService.save(order);
        OrderResponse orderResponse = orderConverter.convert(savedOrder);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<Order> orders = orderService.findAll();
        List<OrderResponse> orderResponses = orders.stream().map(orderConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok(orderResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable long id) {
        Order foundOrder = orderService.findById(id);
        OrderResponse orderResponse = orderConverter.convert(foundOrder);
        return ResponseEntity.ok(orderResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/address/{id}")
    public ResponseEntity<OrderResponse> updateAddress(@PathVariable long id, @RequestBody OrderAddressUpdate orderAddressUpdate) {
        Order updatedOrder = orderService.updateAddress(id, orderAddressUpdate.getAddress());
        OrderResponse orderResponse = orderConverter.convert(updatedOrder);
        return ResponseEntity.ok(orderResponse);
    }

    @PutMapping(value = "/status/{id}")
    public ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable long id, @RequestBody OrderStatusUpdate orderStatusUpdate) {
        Order updatedOrder = orderService.updateOrderStatus(id, orderStatusUpdate.getOrderStatus());
        OrderResponse orderResponse = orderConverter.convert(updatedOrder);
        return ResponseEntity.ok(orderResponse);
    }
}
