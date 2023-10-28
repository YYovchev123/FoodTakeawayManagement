package com.example.FoodTakeawayManagement.converter;

import com.example.FoodTakeawayManagement.dataTransferObject.rating.RatingResponse;
import com.example.FoodTakeawayManagement.dataTransferObject.rating.RatingSaveRequest;
import com.example.FoodTakeawayManagement.model.restaurant.Rating;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RatingConverter {

    public Rating convert(RatingSaveRequest ratingSaveRequest) {
        return Rating.builder()
                .rating(ratingSaveRequest.getRating())
                .description(ratingSaveRequest.getDescription())
                .build();
    }

    public RatingResponse convert(Rating rating) {
        return RatingResponse.builder()
                .id(rating.getId())
                .rating(rating.getRating())
                .description(rating.getDescription())
                .build();
    }
}
