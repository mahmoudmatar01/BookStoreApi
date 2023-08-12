package com.api.BooksApiWithMySql.exceptions;

public class NotFoundResourceCustomException extends Exception {
    private final String message;

    public NotFoundResourceCustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
