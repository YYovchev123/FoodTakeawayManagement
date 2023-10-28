package com.example.FoodTakeawayManagement.dataTransferObject.rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingResponse {
    private long id;
    private int rating;
    private String description;
}
