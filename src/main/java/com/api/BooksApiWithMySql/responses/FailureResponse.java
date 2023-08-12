package com.api.BooksApiWithMySql.responses;

public class FailureResponse extends Response<Object> {
    public FailureResponse(int statusCode, String message) {
        super(statusCode, false, message, null);
    }
}
