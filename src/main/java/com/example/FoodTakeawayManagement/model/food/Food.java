package com.example.FoodTakeawayManagement.model.food;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Food {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String image;

    @NotNull
    private float price;

    @NotNull
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @NotNull
    private String ingredients;
}
