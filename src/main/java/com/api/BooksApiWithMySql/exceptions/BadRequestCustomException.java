package com.api.BooksApiWithMySql.exceptions;

public class BadRequestCustomException extends Exception {
    public BadRequestCustomException(String message) {
        super(message);
    }
}
