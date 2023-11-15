package com.example.FoodTakeawayManagement.model.restaurant;

import com.example.FoodTakeawayManagement.model.food.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String location;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String logoImage;

    @NotNull
    private String image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ratings_id")
    private List<Rating> ratings;

    private float rating;


    // Make the manu an ID which points to a new table with all the foods
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "foods_id")
    private List<Food> menu;

    @Enumerated(EnumType.STRING)
    private RestaurantStatus restaurantStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RestaurantCategory restaurantCategory;

    public void addToMenu(Food food) {
        menu.add(food);
    }

    public void rate(Rating rating) {
        ratings.add(rating);
        float sum = 0;
        for(int i = 0; i < ratings.size(); i++) {
            Rating ratingI = ratings.get(i);
            sum += ratingI.getRating();
        }
        this.rating = sum / ratings.size();
    }
}
