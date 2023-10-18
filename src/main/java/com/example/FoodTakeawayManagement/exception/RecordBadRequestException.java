package com.example.FoodTakeawayManagement.exception;

public class RecordBadRequestException extends RuntimeException{
    public RecordBadRequestException() {
        super();
    }

    public RecordBadRequestException(String message) {
        super(message);
    }
}
