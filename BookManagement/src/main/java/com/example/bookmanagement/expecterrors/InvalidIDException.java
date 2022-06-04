package com.example.bookmanagement.expecterrors;

public class InvalidIDException extends RuntimeException{
    public InvalidIDException(String message) {
        super(message);
    }
}
