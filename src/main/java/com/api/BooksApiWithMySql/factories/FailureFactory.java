package com.api.BooksApiWithMySql.factories;


import com.api.BooksApiWithMySql.responses.FailureResponse;
import com.api.BooksApiWithMySql.responses.Response;

public class FailureFactory extends BaseFactory<Object> {

    private final String message;
    private final int statusCode;

    public FailureFactory(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public Response<Object> createResponse() {
        return new FailureResponse(statusCode, message);
    }
}
