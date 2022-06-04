package com.example.bookmanagement.expecterrors;

public class NoFundsException extends RuntimeException{
    public NoFundsException(String message) {
        super(message);
    }
}