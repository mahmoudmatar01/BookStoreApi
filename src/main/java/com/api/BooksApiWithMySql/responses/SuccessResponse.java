package com.api.BooksApiWithMySql.responses;


public class SuccessResponse<T> extends Response<T> {

    public SuccessResponse(T data) {
        super(200, true, "Success", data);
    }


}
