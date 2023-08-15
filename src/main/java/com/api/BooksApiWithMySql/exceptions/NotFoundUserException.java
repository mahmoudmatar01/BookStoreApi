package com.api.BooksApiWithMySql.exceptions;

public class NotFoundUserException extends Exception {
    public NotFoundUserException(String s) {
        super(s);
    }
}
