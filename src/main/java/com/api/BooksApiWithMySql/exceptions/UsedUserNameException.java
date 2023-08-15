package com.api.BooksApiWithMySql.exceptions;

public class UsedUserNameException extends RuntimeException {
    public UsedUserNameException(String s) {
        super(s);
    }
}
