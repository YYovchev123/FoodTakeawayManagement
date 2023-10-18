package com.example.FoodTakeawayManagement.model.order;

import com.example.FoodTakeawayManagement.model.food.Food;
import com.example.FoodTakeawayManagement.model.restaurant.Restaurant;
import com.example.FoodTakeawayManagement.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Check if this needs fixing
    @ManyToOne
    @NotNull
    private Restaurant restaurant;

    // Check if this needs fixing
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> foods;

    // Check if this needs fixing
    @NotNull
    @ManyToOne
    private User users;

    @NotNull
    private String address;

    @NotNull
    private float price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DeliveryWay deliveryWay;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
