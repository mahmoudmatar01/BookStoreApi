package com.api.BooksApiWithMySql.responses;

public class FailureResponse extends Response<Object> {
    public FailureResponse(String message) {
        super(false, message, null);
    }
}
