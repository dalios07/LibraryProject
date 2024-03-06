package com.example.demo.Exceptions;

public class BookNotAvailbaleException extends RuntimeException {
    public BookNotAvailbaleException(String message) {
        super(message);
    }
}

