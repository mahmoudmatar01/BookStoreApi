package com.api.BooksApiWithMySql.factories;

import com.api.BooksApiWithMySql.responses.Response;
import com.api.BooksApiWithMySql.responses.SuccessResponse;

public class SuccessFactory<T> extends BaseFactory<T> {

    private final T data;

    public SuccessFactory(T data) {
        this.data = data;
    }

    @Override
    public Response<T> createResponse() {
        return new SuccessResponse<T>(data);
    }
}
