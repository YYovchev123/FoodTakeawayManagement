package com.example.FoodTakeawayManagement.dataTransferObject.order;

import com.example.FoodTakeawayManagement.model.order.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusUpdate {
    private OrderStatus orderStatus;
}
