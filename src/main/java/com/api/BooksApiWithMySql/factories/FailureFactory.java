package com.api.BooksApiWithMySql.factories;


import com.api.BooksApiWithMySql.responses.FailureResponse;
import com.api.BooksApiWithMySql.responses.Response;

public class FailureFactory extends BaseFactory<Object> {

    private final String message;

    public FailureFactory(String message) {
        this.message = message;
    }

    @Override
    public Response<Object> createResponse() {
        return new FailureResponse(message);
    }
}
